package com.github.supermoonie.type.cachestorage;

import lombok.Data;

/**
 * Cached response
 * 
 * @author supermoonie
 */
@Data
public class CachedResponse {

    /**
     * Entry content, base64-encoded.
     */
    private String body;

}