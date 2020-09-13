package io.netty.example.study.client.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 *
 * 主要处理粘包和半包的问题
 */

public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {
    public OrderFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
