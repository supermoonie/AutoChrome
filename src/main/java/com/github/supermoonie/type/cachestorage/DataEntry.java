package com.github.supermoonie.type.cachestorage;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Data entry.
 * 
 * @author supermoonie
 */
@Data
public class DataEntry {

    /**
     * Request URL.
     */
    private String requestURL;

    /**
     * Request method.
     */
    private String requestMethod;

    /**
     * Request headers
     */
    private List<Header> requestHeaders = new ArrayList<>();

    /**
     * Number of seconds since epoch.
     */
    private Double responseTime;

    /**
     * HTTP response status code.
     */
    private Integer responseStatus;

    /**
     * HTTP response status text.
     */
    private String responseStatusText;

    /**
     * HTTP response type
     */
    private CachedResponseType responseType;

    /**
     * Response headers
     */
    private List<Header> responseHeaders = new ArrayList<>();

}