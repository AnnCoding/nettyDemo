package io.netty.example.study.common;

import lombok.Data;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */

@Data
public class MessageHeader {

    private int version = 1;
    private int opCode;
    private long streamId;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public long getStreamId() {
        return streamId;
    }

    public void setStreamId(long streamId) {
        this.streamId = streamId;
    }
}
