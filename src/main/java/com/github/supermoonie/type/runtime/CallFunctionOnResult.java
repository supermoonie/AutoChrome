package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class CallFunctionOnResult {
    /**
     * Call result.
     */
    private RemoteObject result;
    /**
     * Exception details.
     */
    private ExceptionDetails exceptionDetails;

}
