package com.github.supermoonie.event.inspector;

import lombok.Data;

/**
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 * 
 * @author supermoonie
 */ 
@Data
public class Detached {

    /**
     * The reason why connection has been terminated.
     */
    private String reason;

}