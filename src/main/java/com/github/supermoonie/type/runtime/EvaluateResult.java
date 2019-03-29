package com.github.supermoonie.type.runtime;


import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class EvaluateResult {

    private RemoteObject result;

    private ExceptionDetails exceptionDetails;

}
