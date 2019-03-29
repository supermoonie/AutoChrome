package com.github.supermoonie.event.network;

import lombok.Data;

/**
 * Fired when WebSocket is closed.
 * 
 * @author supermoonie
 */ 
@Data
public class WebSocketClosed {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

}