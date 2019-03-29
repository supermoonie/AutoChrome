package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class CompileScriptResult {
    private String scriptId;

    private ExceptionDetails exceptionDetails;

}
