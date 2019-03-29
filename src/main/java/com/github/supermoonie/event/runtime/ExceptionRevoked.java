package com.github.supermoonie.event.runtime;

import lombok.Data;

/**
 * Issued when unhandled exception was revoked.
 * 
 * @author supermoonie
 */ 
@Data
public class ExceptionRevoked {

    /**
     * Reason describing why exception was revoked.
     */
    private String reason;

    /**
     * The id of revoked exception, as reported in `exceptionThrown`.
     */
    private Integer exceptionId;

}