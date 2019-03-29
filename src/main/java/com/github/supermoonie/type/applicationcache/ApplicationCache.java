package com.github.supermoonie.type.applicationcache;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Detailed application cache information.
 * 
 * @author supermoonie
 */
@Data
public class ApplicationCache {

    /**
     * Manifest URL.
     */
    private String manifestURL;

    /**
     * Application cache size.
     */
    private Double size;

    /**
     * Application cache creation time.
     */
    private Double creationTime;

    /**
     * Application cache update time.
     */
    private Double updateTime;

    /**
     * Application cache resources.
     */
    private List<ApplicationCacheResource> resources = new ArrayList<>();

}