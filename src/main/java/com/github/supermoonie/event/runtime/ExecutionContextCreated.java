package com.github.supermoonie.event.runtime;

import com.github.supermoonie.type.runtime.ExecutionContextDescription;
import lombok.Data;

/**
 * Issued when new execution context is created.
 * 
 * @author supermoonie
 */ 
@Data
public class ExecutionContextCreated {

    /**
     * A newly created execution context.
     */
    private ExecutionContextDescription context;

}