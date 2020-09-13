package io.netty.example.study.server.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */
public class OrderFrameEncoder extends LengthFieldPrepender {
    public OrderFrameEncoder() {
        super(2);
    }
}
