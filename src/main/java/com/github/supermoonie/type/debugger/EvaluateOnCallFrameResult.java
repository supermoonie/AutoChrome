package com.github.supermoonie.type.debugger;

import com.github.supermoonie.type.runtime.ExceptionDetails;
import com.github.supermoonie.type.runtime.RemoteObject;

/**
 * @author Administrator
 */
public class EvaluateOnCallFrameResult {

    /**
     * Object wrapper for the evaluation result.
     */
    private RemoteObject result;

    /**
     * Exception details.
     */
    private ExceptionDetails exceptionDetails;

    public RemoteObject getResult() {
        return result;
    }

    public void setResult(RemoteObject result) {
        this.result = result;
    }

    public ExceptionDetails getExceptionDetails() {
        return exceptionDetails;
    }

    public void setExceptionDetails(ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }
}
