package com.github.supermoonie.type.indexeddb;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Database with an array of object stores.
 * 
 * @author supermoonie
 */
@Data
public class DatabaseWithObjectStores {

    /**
     * Database name.
     */
    private String name;

    /**
     * Database version.
     */
    private Integer version;

    /**
     * Object stores in this database.
     */
    private List<ObjectStore> objectStores = new ArrayList<>();

}