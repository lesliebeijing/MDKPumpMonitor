package com.lesliefang.mdk.pumpmonitor.netty.handler;

import com.lesliefang.mdk.pumpmonitor.netty.message.DeviceAddressAsk;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("channelActive {}", ctx.channel().remoteAddress());

        DeviceAddressAsk deviceAddressAsk = new DeviceAddressAsk();
        ctx.channel().writeAndFlush(deviceAddressAsk);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        logger.info("channelInactive {}", ctx.channel().remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("11111111111111111 channelRead " + msg.getClass().getSimpleName());
    }
}
