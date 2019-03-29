package com.github.supermoonie.type.network;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a signed exchange response.
 * 
 * @author supermoonie
 */
@Data
public class SignedExchangeInfo {

    /**
     * The outer response of signed HTTP exchange which was received from network.
     */
    private Response outerResponse;

    /**
     * Information about the signed exchange header.
     */
    private SignedExchangeHeader header;

    /**
     * Security details for the signed exchange header.
     */
    private SecurityDetails securityDetails;

    /**
     * Errors occurred while handling the signed exchagne.
     */
    private List<SignedExchangeError> errors = new ArrayList<>();

}