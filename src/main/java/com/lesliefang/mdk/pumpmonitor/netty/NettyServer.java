package com.lesliefang.mdk.pumpmonitor.netty;

import com.lesliefang.mdk.pumpmonitor.netty.handler.MessageDecoder;
import com.lesliefang.mdk.pumpmonitor.netty.handler.MessageEncoder;
import com.lesliefang.mdk.pumpmonitor.netty.handler.MyLengthFieldBasedFrameDecoder;
import com.lesliefang.mdk.pumpmonitor.netty.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
    private static final int READ_TIMEOUT = 30;
    private static final int PORT = 5510;

    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new IdleStateHandler(READ_TIMEOUT, 0, 0));
                            ch.pipeline().addLast(new MyLengthFieldBasedFrameDecoder());
                            ch.pipeline().addLast(new MessageEncoder());
                            ch.pipeline().addLast(new MessageDecoder());
                            ch.pipeline().addLast(new ServerHandler());
                        }
                    });
            ChannelFuture f = b.bind(PORT).sync();

            logger.info("server start listening at {}", PORT);

            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

            logger.info("server shutdown");
        }
    }

    public static void main(String[] args) {
        new NettyServer().run();
    }
}
