package com.github.supermoonie.event.storage;

import lombok.Data;

/**
 * A cache's contents have been modified.
 * 
 * @author supermoonie
 */ 
@Data
public class CacheStorageContentUpdated {

    /**
     * Origin to update.
     */
    private String origin;

    /**
     * Name of cache in origin.
     */
    private String cacheName;

}