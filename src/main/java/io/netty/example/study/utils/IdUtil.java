package io.netty.example.study.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */
public final class IdUtil {

    private static final AtomicLong IDX = new AtomicLong();

    private IdUtil() {
        //no instance
    }

    public static long nextId() {
        return IDX.incrementAndGet();
    }

}