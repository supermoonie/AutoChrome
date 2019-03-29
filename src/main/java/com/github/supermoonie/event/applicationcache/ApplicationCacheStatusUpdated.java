package com.github.supermoonie.event.applicationcache;

import lombok.Data;

/**
 * @author supermoonie
 */ 
@Data
public class ApplicationCacheStatusUpdated {

    /**
     * Identifier of the frame containing document whose application cache updated status.
     */
    private String frameId;

    /**
     * Manifest URL.
     */
    private String manifestURL;

    /**
     * Updated application cache status.
     */
    private Integer status;

}