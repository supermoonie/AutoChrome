package com.github.supermoonie.type.network;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Information about a signed exchange header.
https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
 * 
 * @author supermoonie
 */
@Data
public class SignedExchangeHeader {

    /**
     * Signed exchange request URL.
     */
    private String requestUrl;

    /**
     * Signed exchange request method.
     */
    private String requestMethod;

    /**
     * Signed exchange response code.
     */
    private Integer responseCode;

    /**
     * Signed exchange response headers.
     */
    private Map<String, Object> responseHeaders = new HashMap<>();

    /**
     * Signed exchange response signature.
     */
    private List<SignedExchangeSignature> signatures = new ArrayList<>();

}