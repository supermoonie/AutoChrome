package com.github.supermoonie.event.storage;

import lombok.Data;

/**
 * The origin's IndexedDB object store has been modified.
 * 
 * @author supermoonie
 */ 
@Data
public class IndexedDBContentUpdated {

    /**
     * Origin to update.
     */
    private String origin;

    /**
     * Database to update.
     */
    private String databaseName;

    /**
     * ObjectStore to update.
     */
    private String objectStoreName;

}