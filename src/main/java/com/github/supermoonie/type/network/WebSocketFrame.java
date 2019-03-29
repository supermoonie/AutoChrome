package com.github.supermoonie.type.network;

import lombok.Data;

/**
 * WebSocket frame data.
 * 
 * @author supermoonie
 */
@Data
public class WebSocketFrame {

    /**
     * WebSocket frame opcode.
     */
    private Double opcode;

    /**
     * WebSocke frame mask.
     */
    private Boolean mask;

    /**
     * WebSocke frame payload data.
     */
    private String payloadData;

}