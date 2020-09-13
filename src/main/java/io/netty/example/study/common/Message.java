package io.netty.example.study.common;

import io.netty.buffer.ByteBuf;
import io.netty.example.study.utils.JsonUtil;
import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */

@Data
public abstract class Message<T extends MessageBody> {

    private MessageHeader messageHeader;
    private T messageBody;

    public T getMessageBody() {
        return messageBody;
    }

    public void encode(ByteBuf byteBuf){
        byteBuf.writeInt(messageHeader.getVersion());
        byteBuf.writeLong(messageHeader.getStreamId());
        byteBuf.writeInt(messageHeader.getOpCode());
        byteBuf.writeBytes(JsonUtil.toJson(messageBody).getBytes());
    }

    public void decode(ByteBuf msg){
        int version  =msg.readInt();
        long streamId = msg.readLong();
        int opCode = msg.readInt();

        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setVersion(version);
        messageHeader.setOpCode(opCode);
        messageHeader.setStreamId(streamId);
        this.messageHeader = messageHeader;

        Class<T> bodyClazz = getMessageBodyDecodeClass(opCode);
        T body = JsonUtil.fromJson(msg.toString(StandardCharsets.UTF_8),bodyClazz);
        this.messageBody = body;
    }

    public abstract Class<T> getMessageBodyDecodeClass(int opcode);

    //todo
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public void setMessageBody(T messageBody) {
        this.messageBody = messageBody;
    }
}
