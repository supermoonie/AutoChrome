package com.github.supermoonie.type.indexeddb;

import lombok.Data;

/**
 * Object store index.
 * 
 * @author supermoonie
 */
@Data
public class ObjectStoreIndex {

    /**
     * Index name.
     */
    private String name;

    /**
     * Index key path.
     */
    private KeyPath keyPath;

    /**
     * If true, index is unique.
     */
    private Boolean unique;

    /**
     * If true, index allows multiple entries for a key.
     */
    private Boolean multiEntry;

}