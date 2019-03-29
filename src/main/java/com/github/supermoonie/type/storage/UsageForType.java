package com.github.supermoonie.type.storage;

import lombok.Data;

/**
 * Usage for a storage type.
 * 
 * @author supermoonie
 */
@Data
public class UsageForType {

    /**
     * Name of storage type.
     */
    private StorageType storageType;

    /**
     * Storage usage (bytes).
     */
    private Double usage;

}