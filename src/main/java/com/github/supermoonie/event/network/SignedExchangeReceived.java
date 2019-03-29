package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.SignedExchangeInfo;
import lombok.Data;

/**
 * Fired when a signed exchange was received over the network
 * 
 * @author supermoonie
 */ 
@Data
public class SignedExchangeReceived {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Information about the signed exchange response.
     */
    private SignedExchangeInfo info;

}