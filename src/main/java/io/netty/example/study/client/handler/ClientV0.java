package io.netty.example.study.client.handler;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.server.codec.OrderFrameDecoder;
import io.netty.example.study.server.codec.OrderFrameEncoder;
import io.netty.example.study.server.codec.OrderProtocolDecoder;
import io.netty.example.study.server.codec.OrderProtocolEncoder;
import io.netty.example.study.server.handler.OrderServerProcessHandler;
import io.netty.example.study.utils.IdUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */

public class ClientV0 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new LoggingHandler(LogLevel.INFO));
        bootstrap.group(new NioEventLoopGroup());


        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {

            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                ChannelPipeline pipeline = nioSocketChannel.pipeline();

                //这个顺序必能变
                pipeline.addLast(new OrderFrameDecoder());
                pipeline.addLast(new OrderFrameEncoder());
                pipeline.addLast(new OrderProtocolEncoder());
                pipeline.addLast(new OrderProtocolDecoder());

                pipeline.addLast(new LoggingHandler(LogLevel.INFO));

            }
        });

        ChannelFuture future = bootstrap.connect("127.0.0.1",8091);

        future.sync();

        RequestMessage message = new RequestMessage(IdUtil.nextId(),new OrderOperation(100,"huluobo"));

        future.channel().writeAndFlush(message);

        future.channel().closeFuture().get();
    }
}
