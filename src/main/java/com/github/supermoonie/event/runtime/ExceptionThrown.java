package com.github.supermoonie.event.runtime;

import com.github.supermoonie.type.runtime.ExceptionDetails;
import lombok.Data;

/**
 * Issued when exception was thrown and unhandled.
 * 
 * @author supermoonie
 */ 
@Data
public class ExceptionThrown {

    /**
     * Timestamp of the exception.
     */
    private Double timestamp;

    private ExceptionDetails exceptionDetails;

}