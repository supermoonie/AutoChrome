package com.github.supermoonie.event.runtime;

import lombok.Data;

/**
 * Notification is issued every time when binding is called.
 * 
 * @author supermoonie
 */ 
@Data
public class BindingCalled {

    private String name;

    private String payload;

    /**
     * Identifier of the context where the call was made.
     */
    private Integer executionContextId;

}