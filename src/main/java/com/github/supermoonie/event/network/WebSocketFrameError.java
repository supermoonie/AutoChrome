package com.github.supermoonie.event.network;

import lombok.Data;

/**
 * Fired when WebSocket frame error occurs.
 * 
 * @author supermoonie
 */ 
@Data
public class WebSocketFrameError {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * WebSocket frame error message.
     */
    private String errorMessage;

}