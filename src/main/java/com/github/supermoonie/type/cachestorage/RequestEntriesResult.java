package com.github.supermoonie.type.cachestorage;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class RequestEntriesResult {

    /**
     * Array of object store data entries.
     */
    private List<DataEntry> cacheDataEntries;

    /**
     * If true, there are more entries to fetch in the given range.
     */
    private Boolean hasMore;

}
