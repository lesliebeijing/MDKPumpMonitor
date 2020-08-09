package com.lesliefang.mdk.pumpmonitor.netty.handler;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.*;
import com.lesliefang.mdk.pumpmonitor.netty.model.DeviceContext;
import com.lesliefang.mdk.pumpmonitor.netty.util.Address;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    public static ConcurrentHashMap<String, DeviceContext> deviceListMap = new ConcurrentHashMap<>();

    private Logger logger = LoggerFactory.getLogger(ServerHandler.class);
    private static final AttributeKey<String> snKey = AttributeKey.valueOf("sn");

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("channelActive {}", ctx.channel().remoteAddress());

        // 设备首次上线发送地址查询指令
        DeviceAddressAsk deviceAddressAsk = new DeviceAddressAsk();
        ctx.channel().writeAndFlush(deviceAddressAsk);
        logger.debug(">>>{} DeviceAddressAsk", ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        logger.info("channelInactive {}", ctx.channel().remoteAddress());

        String sn = ctx.channel().attr(snKey).get();
        if (sn != null && deviceListMap.containsKey(sn)) {
            deviceListMap.remove(sn);
            logger.debug("{} {} detach", sn, ctx.channel().remoteAddress());
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = ((IdleStateEvent) evt);
            if (e.state() == IdleState.READER_IDLE) {
                logger.info("{} read idle close channel", ctx.channel().remoteAddress());
                ctx.close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!(msg instanceof ResponseMessage)) {
            return;
        }

        ResponseMessage respMsg = ((ResponseMessage) msg);
        short cmd = respMsg.getCmd();
        if (cmd == CMD.DEVICE_ADDRESS_ASK) {
            logger.debug("<<<{} DeviceAddressAskReply", ctx.channel().remoteAddress());
            DeviceAddressAskReply deviceAddressAskReply = ((DeviceAddressAskReply) respMsg);
            String sn = Address.parsePumpAddress(respMsg.getSrcAddress());
            if (sn != null) {
                ctx.channel().attr(snKey).set(sn);
                DeviceContext deviceContext = new DeviceContext();
                deviceContext.setSn(sn);
                deviceContext.setDeviceType(deviceAddressAskReply.getDeviceType());
                deviceListMap.put(sn, deviceContext);
                logger.debug("{} {} attach", sn, ctx.channel().remoteAddress());

                ctx.channel().eventLoop().scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        // 设备状态查询
                        DeviceStateAsk deviceStateAsk = new DeviceStateAsk();
                        ctx.channel().writeAndFlush(deviceStateAsk);
                        logger.debug(">>>{} DeviceStateAsk", sn);

                        // 床号信息查询
                        BedInfoAsk bedInfoAsk = new BedInfoAsk();
                        ctx.channel().writeAndFlush(bedInfoAsk);
                    }
                }, 0, 2, TimeUnit.SECONDS);
            } else {
                logger.debug("parse sn error {}", ctx.channel().remoteAddress());
            }
        }

        String sn = ctx.channel().attr(snKey).get();
        if (sn == null) {
            logger.debug("no sn {}", ctx.channel().remoteAddress());
            return;
        }
        DeviceContext deviceContext = deviceListMap.get(sn);
        if (deviceContext == null) {
            logger.debug("deviceContext is null {} {}", sn, ctx.channel().remoteAddress());
            return;
        }

        if (cmd == CMD.DEVICE_STATE_ASK) {
            logger.debug("<<<{} DeviceStateAskReply", sn);
            DeviceStateAskReply deviceStateAskReply = ((DeviceStateAskReply) respMsg);
            deviceContext.setDeviceState(deviceStateAskReply.getDeviceState());
            logger.debug("{}", deviceContext);
        } else if (cmd == CMD.BED_INFO_ASK) {
            BedInfoAskReply bedInfoAskReply = ((BedInfoAskReply) respMsg);
            deviceContext.setBedNum(bedInfoAskReply.getBedNum() + "");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
