package com.github.supermoonie.event.network;

import lombok.Data;

/**
 * Fired when data chunk was received over the network.
 * 
 * @author supermoonie
 */ 
@Data
public class DataReceived {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * Data chunk length.
     */
    private Integer dataLength;

    /**
     * Actual bytes received (might be less than dataLength for compressed encodings).
     */
    private Integer encodedDataLength;

}