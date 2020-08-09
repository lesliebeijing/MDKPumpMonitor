package com.lesliefang.mdk.pumpmonitor.netty.handler;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.*;
import com.lesliefang.mdk.pumpmonitor.netty.message.infusion.*;
import com.lesliefang.mdk.pumpmonitor.netty.model.DeviceContext;
import com.lesliefang.mdk.pumpmonitor.netty.model.DeviceState;
import com.lesliefang.mdk.pumpmonitor.netty.model.DeviceType;
import com.lesliefang.mdk.pumpmonitor.netty.model.feeding.FeedingPumpContext;
import com.lesliefang.mdk.pumpmonitor.netty.model.gravity.GravityPumpContext;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpContext;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpWeightParam;
import com.lesliefang.mdk.pumpmonitor.netty.model.workstation.WorkStationContext;
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
        ctx.channel().writeAndFlush(new DeviceAddressAsk());
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
            if (sn == null) {
                logger.debug("parse sn error {}", ctx.channel().remoteAddress());
                return;
            }
            DeviceContext deviceContext = null;
            short deviceType = deviceAddressAskReply.getDeviceType();
            if (deviceType == DeviceType.INFUSION_PUMP
                    || deviceType == DeviceType.INJECTION_PUMP
                    || deviceType == DeviceType.WORKSTATION_INFUSION_PUMP
                    || deviceType == DeviceType.WORKSTATION_INJECTION_PUMP) {
                deviceContext = new InfusionPumpContext();
            } else if (deviceType == DeviceType.NUTRITION_PUMP) {
                deviceContext = new FeedingPumpContext();
            } else if (deviceType == DeviceType.GRAVITY_DROP_MC1
                    || deviceType == DeviceType.GRAVITY_DROP_MC2) {
                deviceContext = new GravityPumpContext();
            } else if (deviceType == DeviceType.INFUSION_WORKSTATION) {
                deviceContext = new WorkStationContext();
            }
            if (deviceContext == null) {
                logger.debug("deviceContext is null {} {}", sn, ctx.channel().remoteAddress());
                return;
            }

            ctx.channel().attr(snKey).set(sn);
            deviceContext.setSn(sn);
            deviceContext.setDeviceType(deviceType);
            deviceListMap.put(sn, deviceContext);
            logger.debug("{} {} attach", sn, ctx.channel().remoteAddress());

            ctx.channel().eventLoop().scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    // 设备状态查询
                    ctx.channel().writeAndFlush(new DeviceStateAsk());
                    logger.debug(">>>{} DeviceStateAsk", sn);
                }
            }, 0, 2, TimeUnit.SECONDS);
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

            // 床号信息查询
            ctx.channel().writeAndFlush(new BedInfoAsk());
            logger.debug(">>>{} BedInfoAsk", sn);

            short deviceType = deviceContext.getDeviceType();
            short deviceState = deviceContext.getDeviceState();
            if (deviceType == DeviceType.INFUSION_PUMP
                    || deviceType == DeviceType.INJECTION_PUMP
                    || deviceType == DeviceType.WORKSTATION_INFUSION_PUMP
                    || deviceType == DeviceType.WORKSTATION_INJECTION_PUMP) {
                if (deviceState == DeviceState.DEVICE_STAT_NM_INFUSION
                        || deviceState == DeviceState.DEVICE_STAT_NM_INJECTING) {
                    ctx.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            // 工作信息查询
                            ctx.channel().writeAndFlush(new InfusionPumpWorkInfoAsk());
                            logger.debug(">>>{} InfusionPumpWorkInfoAsk", sn);
                        }
                    }, 500, TimeUnit.MILLISECONDS);
                } else {
                    ctx.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            // 工作参数查询
                            ctx.channel().writeAndFlush(new InfusionPumpWorkParamAsk());
                            logger.debug(">>>{} InfusionPumpWorkParamAsk", sn);
                        }
                    }, 500, TimeUnit.MILLISECONDS);
                    ctx.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            // 体重参数查询
                            ctx.channel().writeAndFlush(new InfusionPumpWeightParamAsk());
                            logger.debug(">>>{} InfusionPumpWeightParamAsk", sn);
                        }
                    }, 1000, TimeUnit.MILLISECONDS);
                }
            }
        } else if (cmd == CMD.BED_INFO_ASK) {
            logger.debug("<<<{} BedInfoAskReply", sn);
            BedInfoAskReply bedInfoAskReply = ((BedInfoAskReply) respMsg);
            deviceContext.setBedNum(bedInfoAskReply.getBedNum() + "");
        } else if (cmd == CMD.INFUSION_PUMP_WORK_INFO_ASK) {
            logger.debug("<<<{} InfusionPumpWorkInfoAskReply", sn);
            InfusionPumpContext infusionPumpContext = ((InfusionPumpContext) deviceContext);
            InfusionPumpWorkInfoAskReply infusionPumpWorkInfoAskReply = ((InfusionPumpWorkInfoAskReply) respMsg);
            infusionPumpContext.setWorkInfo(infusionPumpWorkInfoAskReply.getInfusionPumpWorkInfo());
        } else if (cmd == CMD.INFUSION_PUMP_WORK_PARAM_ASK) {
            logger.debug("<<<{} InfusionPumpWorkParamAskReply", sn);
            InfusionPumpContext infusionPumpContext = ((InfusionPumpContext) deviceContext);
            InfusionPumpWorkParamAskReply infusionPumpWorkParamAskReply = ((InfusionPumpWorkParamAskReply) respMsg);
            infusionPumpContext.setWorkParam(infusionPumpWorkParamAskReply.getInfusionPumpWorkParam());
        } else if (cmd == CMD.INFUSION_PUMP_WEIGHT_PARAM_ASK) {
            logger.debug("<<<{} InfusionPumpWeightParamAskReply", sn);
            InfusionPumpContext infusionPumpContext = ((InfusionPumpContext) deviceContext);
            InfusionPumpWeightParamAskReply infusionPumpWeightParamAskReply = ((InfusionPumpWeightParamAskReply) respMsg);
            infusionPumpContext.setWeightParam(infusionPumpWeightParamAskReply.getInfusionPumpWeightParam());
        }

        logger.debug("{}", deviceContext);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
