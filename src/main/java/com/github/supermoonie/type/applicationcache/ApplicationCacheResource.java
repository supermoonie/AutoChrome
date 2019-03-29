package com.github.supermoonie.type.applicationcache;

import lombok.Data;

/**
 * Detailed application cache resource information.
 * 
 * @author supermoonie
 */
@Data
public class ApplicationCacheResource {

    /**
     * Resource url.
     */
    private String url;

    /**
     * Resource size.
     */
    private Integer size;

    /**
     * Resource type.
     */
    private String type;

}