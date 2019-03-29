package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class RunScriptResult {
    private RemoteObject result;

    private ExceptionDetails exceptionDetails;

}
