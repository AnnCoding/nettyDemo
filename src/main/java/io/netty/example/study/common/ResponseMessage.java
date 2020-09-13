package io.netty.example.study.common;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */
public class ResponseMessage extends Message<OperationResult>{
    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationResultClazz();
    }
}
