package com.github.supermoonie.event.storage;

import lombok.Data;

/**
 * A cache has been added/deleted.
 * 
 * @author supermoonie
 */ 
@Data
public class CacheStorageListUpdated {

    /**
     * Origin to update.
     */
    private String origin;

}