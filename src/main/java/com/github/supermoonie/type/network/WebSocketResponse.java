package com.github.supermoonie.type.network;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * WebSocket response data.
 * 
 * @author supermoonie
 */
@Data
public class WebSocketResponse {

    /**
     * HTTP response status code.
     */
    private Integer status;

    /**
     * HTTP response status text.
     */
    private String statusText;

    /**
     * HTTP response headers.
     */
    private Map<String, Object> headers = new HashMap<>();

    /**
     * HTTP response headers text.
     */
    private String headersText;

    /**
     * HTTP request headers.
     */
    private Map<String, Object> requestHeaders = new HashMap<>();

    /**
     * HTTP request headers text.
     */
    private String requestHeadersText;

}