package com.github.supermoonie.event.target;

import lombok.Data;

/**
 * Issued when a target has crashed.
 * 
 * @author supermoonie
 */ 
@Data
public class TargetCrashed {

    private String targetId;

    /**
     * Termination status type.
     */
    private String status;

    /**
     * Termination error code.
     */
    private Integer errorCode;

}