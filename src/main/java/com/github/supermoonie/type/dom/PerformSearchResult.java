package com.github.supermoonie.type.dom;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class PerformSearchResult {

    /**
     * Unique search session identifier.
     */
    private String searchId;

    /**
     * Number of search results.
     */
    private Integer resultCount;

}
