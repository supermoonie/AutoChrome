package com.github.supermoonie.type.indexeddb;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class RequestDataResult {
    private List<DataEntry> objectStoreDataEntries;

    private Boolean hasMore;

}
