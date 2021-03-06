package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.WebSocketFrame;
import lombok.Data;

/**
 * Fired when WebSocket frame is received.
 * 
 * @author supermoonie
 */ 
@Data
public class WebSocketFrameReceived {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * WebSocket response data.
     */
    private WebSocketFrame response;

}