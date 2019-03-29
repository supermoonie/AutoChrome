package com.github.supermoonie.event.network;

import lombok.Data;

/**
 * Fired if request ended up loading from cache.
 * 
 * @author supermoonie
 */ 
@Data
public class RequestServedFromCache {

    /**
     * Request identifier.
     */
    private String requestId;

}