package io.netty.example.study.server.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.RequestMessage;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 *
 * 二次解码器
 */
public class OrderProtocolDecoder extends MessageToMessageDecoder<ByteBuf>  {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out)
            throws Exception {

        RequestMessage requestMessage = new RequestMessage();
        requestMessage.decode(byteBuf);

        out.add(requestMessage);
    }
}
