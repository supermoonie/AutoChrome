package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class AwaitPromiseResult {
    /**
     * Promise result. Will contain rejected value if promise was rejected.
     */
    private RemoteObject result;
    /**
     * Exception details if stack strace is available.
     */
    private ExceptionDetails exceptionDetails;

}
