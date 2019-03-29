package com.github.supermoonie.event.storage;

import lombok.Data;

/**
 * The origin's IndexedDB database list has been modified.
 * 
 * @author supermoonie
 */ 
@Data
public class IndexedDBListUpdated {

    /**
     * Origin to update.
     */
    private String origin;

}