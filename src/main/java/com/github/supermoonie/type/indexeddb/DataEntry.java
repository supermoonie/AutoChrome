package com.github.supermoonie.type.indexeddb;

import com.github.supermoonie.type.runtime.RemoteObject;
import lombok.Data;

/**
 * Data entry.
 * 
 * @author supermoonie
 */
@Data
public class DataEntry {

    /**
     * Key object.
     */
    private RemoteObject key;

    /**
     * Primary key object.
     */
    private RemoteObject primaryKey;

    /**
     * Value object.
     */
    private RemoteObject value;

}