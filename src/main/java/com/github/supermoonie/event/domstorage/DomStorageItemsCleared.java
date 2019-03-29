package com.github.supermoonie.event.domstorage;

import com.github.supermoonie.type.domstorage.StorageId;
import lombok.Data;

/**
 * @author supermoonie
 */ 
@Data
public class DomStorageItemsCleared {

    private StorageId storageId;

}