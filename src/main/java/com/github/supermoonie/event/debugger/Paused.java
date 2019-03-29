package com.github.supermoonie.event.debugger;

import com.github.supermoonie.type.debugger.CallFrame;
import com.github.supermoonie.type.debugger.PauseReason;
import com.github.supermoonie.type.runtime.StackTrace;
import com.github.supermoonie.type.runtime.StackTraceId;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
 * 
 * @author supermoonie
 */ 
@Data
public class Paused {

    /**
     * Call stack the virtual machine stopped on.
     */
    private List<CallFrame> callFrames = new ArrayList<>();

    /**
     * Pause reason.
     */
    private PauseReason reason;

    /**
     * Object containing break-specific auxiliary properties.
     */
    private Object data;

    /**
     * Hit breakpoints IDs
     */
    private List<String> hitBreakpoints = new ArrayList<>();

    /**
     * Async stack trace, if any.
     */
    private StackTrace asyncStackTrace;

    /**
     * Async stack trace, if any.
     */
    private StackTraceId asyncStackTraceId;

    /**
     * Just scheduled async call will have this stack trace as parent stack during async execution.
This field is available only after `Debugger.stepInto` call with `breakOnAsynCall` flag.
     */
    private StackTraceId asyncCallStackTraceId;

}