package com.github.supermoonie.event.runtime;

import com.github.supermoonie.type.runtime.ConsoleApiCallType;
import com.github.supermoonie.type.runtime.RemoteObject;
import com.github.supermoonie.type.runtime.StackTrace;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Issued when console API was called.
 * 
 * @author supermoonie
 */ 
@Data
public class ConsoleAPICalled {

    /**
     * Type of the call.
     */
    private ConsoleApiCallType type;

    /**
     * Call arguments.
     */
    private List<RemoteObject> args = new ArrayList<>();

    /**
     * Identifier of the context where the call was made.
     */
    private Integer executionContextId;

    /**
     * Call timestamp.
     */
    private Double timestamp;

    /**
     * Stack trace captured when the call was made.
     */
    private StackTrace stackTrace;

    /**
     * Console context descriptor for calls on non-default console context (not console.*):
'anonymous#unique-logger-id' for call on unnamed context, 'name#unique-logger-id' for call
on named context.
     */
    private String context;

}