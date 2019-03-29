package com.github.supermoonie.type.domstorage;

import lombok.Data;

/**
 * DOM Storage identifier.
 * 
 * @author supermoonie
 */
@Data
public class StorageId {

    /**
     * Security origin for the storage.
     */
    private String securityOrigin;

    /**
     * Whether the storage is local storage (not session storage).
     */
    private Boolean isLocalStorage;

}