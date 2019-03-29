package com.github.supermoonie.type.indexeddb;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Object store.
 * 
 * @author supermoonie
 */
@Data
public class ObjectStore {

    /**
     * Object store name.
     */
    private String name;

    /**
     * Object store key path.
     */
    private KeyPath keyPath;

    /**
     * If true, object store has auto increment flag set.
     */
    private Boolean autoIncrement;

    /**
     * Indexes in this object store.
     */
    private List<ObjectStoreIndex> indexes = new ArrayList<>();

}