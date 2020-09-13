package io.netty.example.study.common.auth;

import io.netty.example.study.common.OperationResult;
import lombok.Data;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */

@Data
public class AuthOperationResult extends OperationResult {
    private final boolean passAuth;

    public AuthOperationResult(boolean passAuth) {
        this.passAuth = passAuth;
    }

    public AuthOperationResult() {
        passAuth = false;
    }

    public boolean isPassAuth() {
        return passAuth;
    }
}
