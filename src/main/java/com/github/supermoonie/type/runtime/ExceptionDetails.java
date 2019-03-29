package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * Detailed information about exception (or error) that was thrown during script compilation or
execution.
 * 
 * @author supermoonie
 */
@Data
public class ExceptionDetails {

    /**
     * Exception id.
     */
    private Integer exceptionId;

    /**
     * Exception text, which should be used together with exception object when available.
     */
    private String text;

    /**
     * Line number of the exception location (0-based).
     */
    private Integer lineNumber;

    /**
     * Column number of the exception location (0-based).
     */
    private Integer columnNumber;

    /**
     * Script ID of the exception location.
     */
    private String scriptId;

    /**
     * URL of the exception location, to be used when the script was not reported.
     */
    private String url;

    /**
     * JavaScript stack trace if available.
     */
    private StackTrace stackTrace;

    /**
     * Exception object if available.
     */
    private RemoteObject exception;

    /**
     * Identifier of the context where exception happened.
     */
    private Integer executionContextId;

}