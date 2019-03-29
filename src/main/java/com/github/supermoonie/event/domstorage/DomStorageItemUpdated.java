package com.github.supermoonie.event.domstorage;

import com.github.supermoonie.type.domstorage.StorageId;
import lombok.Data;

/**
 * @author supermoonie
 */ 
@Data
public class DomStorageItemUpdated {

    private StorageId storageId;

    private String key;

    private String oldValue;

    private String newValue;

}