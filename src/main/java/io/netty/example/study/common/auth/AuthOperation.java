package io.netty.example.study.common.auth;

import io.netty.example.study.common.Operation;
import io.netty.example.study.common.OperationResult;
import lombok.Data;
import lombok.extern.java.Log;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */
@Data
@Log
public class AuthOperation extends Operation {

    private String userName;
    private String password;

    public AuthOperation(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public OperationResult execute() {
        if ("admin".equalsIgnoreCase(this.userName)) {
            AuthOperationResult orderResponse = new AuthOperationResult(true);
            return orderResponse;
        }

        return new AuthOperationResult(false);
    }
}
