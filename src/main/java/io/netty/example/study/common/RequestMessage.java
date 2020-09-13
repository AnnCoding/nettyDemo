package io.netty.example.study.common;

import io.netty.example.study.utils.JsonUtil;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */
public class RequestMessage extends Message<Operation> {

    public RequestMessage(Long streamId,Operation operation) {

        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setStreamId(streamId);
        messageHeader.setOpCode(OperationType.fromOperation(operation).getOpCode());
        this.setMessageHeader(messageHeader);
        this.setMessageBody(operation);
    }

    public RequestMessage() {

    }

    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationClazz();
    }
}
