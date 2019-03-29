package com.github.supermoonie.type.debugger;

import com.github.supermoonie.type.runtime.StackTrace;
import com.github.supermoonie.type.runtime.StackTraceId;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class RestartFrameResult {

    /**
     * New stack trace.
     */
    private List<CallFrame> callFrames;

    /**
     * Async stack trace, if any.
     */
    private StackTrace asyncStackTrace;

    /**
     * Async stack trace, if any.
     */
    private StackTraceId asyncStackTraceId;

}
