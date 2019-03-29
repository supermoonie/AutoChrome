package com.github.supermoonie.event.runtime;

import lombok.Data;

/**
 * Issued when execution context is destroyed.
 * 
 * @author supermoonie
 */ 
@Data
public class ExecutionContextDestroyed {

    /**
     * Id of the destroyed context
     */
    private Integer executionContextId;

}