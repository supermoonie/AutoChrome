package com.github.supermoonie.type.log;

import com.github.supermoonie.type.runtime.RemoteObject;
import com.github.supermoonie.type.runtime.StackTrace;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Log entry.
 * 
 * @author supermoonie
 */
@Data
public class LogEntry {

    /**
     * Log entry source.
     */
    private String source;

    /**
     * Log entry severity.
     */
    private String level;

    /**
     * Logged text.
     */
    private String text;

    /**
     * Timestamp when this entry was added.
     */
    private Double timestamp;

    /**
     * URL of the resource if known.
     */
    private String url;

    /**
     * Line number in the resource.
     */
    private Integer lineNumber;

    /**
     * JavaScript stack trace.
     */
    private StackTrace stackTrace;

    /**
     * Identifier of the network request associated with this entry.
     */
    private String networkRequestId;

    /**
     * Identifier of the worker associated with this entry.
     */
    private String workerId;

    /**
     * Call arguments.
     */
    private List<RemoteObject> args = new ArrayList<>();

}