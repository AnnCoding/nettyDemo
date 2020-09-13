package io.netty.example.study.common;

import io.netty.example.study.common.auth.AuthOperation;
import io.netty.example.study.common.auth.AuthOperationResult;
import io.netty.example.study.common.keepalive.KeepaliveOperation;
import io.netty.example.study.common.keepalive.KeepaliveOperationResult;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.common.order.OrderOperationResult;

import java.util.function.Predicate;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */
public enum OperationType {
    AUTH(1, AuthOperation.class, AuthOperationResult.class),
    KEEPALIVE(2, KeepaliveOperation.class, KeepaliveOperationResult.class),
    ORDER(3, OrderOperation.class, OrderOperationResult.class)

    ;

    private int opCode;
    private Class<? extends Operation> operationClazz;
    private Class<? extends OperationResult> operationResultClazz;

    OperationType(int opCode, Class<? extends Operation> operationClazz,
            Class<? extends OperationResult> operationResultClazz) {
        this.opCode = opCode;
        this.operationClazz = operationClazz;
        this.operationResultClazz = operationResultClazz;
    }

    public int getOpCode() {
        return opCode;
    }

    public Class<? extends Operation> getOperationClazz() {
        return operationClazz;
    }

    public Class<? extends OperationResult> getOperationResultClazz() {
        return operationResultClazz;
    }

    /**
     * Predicate是一个布尔类型的函数，该函数只有一个输入参数
     * @param predicate
     * @return
     */
    private static OperationType getOperationType(Predicate<OperationType> predicate){
        OperationType[] values = values();
        for (OperationType operationType:values){
            if (predicate.test(operationType)){
                return operationType;
            }
        }

        throw new AssertionError("no found type");
    }

    public static OperationType fromOpCode(int type){
        return getOperationType(t->t.opCode == type);
    }

    public static OperationType fromOperation(Operation operation){
        return getOperationType(t->t.operationClazz == operation.getClass());
    }



}
