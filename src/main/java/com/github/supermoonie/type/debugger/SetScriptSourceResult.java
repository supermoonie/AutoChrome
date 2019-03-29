package com.github.supermoonie.type.debugger;

import com.github.supermoonie.type.runtime.ExceptionDetails;
import com.github.supermoonie.type.runtime.StackTrace;
import com.github.supermoonie.type.runtime.StackTraceId;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class SetScriptSourceResult {

    /**
     * New stack trace in case editing has happened while VM was stopped.
     */
    private List<CallFrame> callFrames;

    /**
     * Whether current call stack was modified after applying the changes.
     */
    private Boolean stackChanged;

    /**
     * Async stack trace, if any.
     */
    private StackTrace asyncStackTrace;

    /**
     * Async stack trace, if any.
     */
    private StackTraceId asyncStackTraceId;

    /**
     * Exception details if any.
     */
    private ExceptionDetails exceptionDetails;

}
