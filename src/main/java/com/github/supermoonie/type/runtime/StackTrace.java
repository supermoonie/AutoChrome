package com.github.supermoonie.type.runtime;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Call frames for assertions or error messages.
 * 
 * @author supermoonie
 */
@Data
public class StackTrace {

    /**
     * String label of this stack trace. For async traces this may be a name of the function that
initiated the async call.
     */
    private String description;

    /**
     * JavaScript function name.
     */
    private List<CallFrame> callFrames = new ArrayList<>();

    /**
     * Asynchronous JavaScript stack trace that preceded this stack, if available.
     */
    private StackTrace parent;

    /**
     * Asynchronous JavaScript stack trace that preceded this stack, if available.
     */
    private StackTraceId parentId;

}