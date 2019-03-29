package com.github.supermoonie.event.target;

import lombok.Data;

/**
 * Issued when detached from target for any reason (including `detachFromTarget` command). Can be
issued multiple times per target if multiple sessions have been attached to it.
 * 
 * @author supermoonie
 */ 
@Data
public class DetachedFromTarget {

    /**
     * Detached session identifier.
     */
    private String sessionId;

    /**
     * Deprecated.
     */
    private String targetId;

}