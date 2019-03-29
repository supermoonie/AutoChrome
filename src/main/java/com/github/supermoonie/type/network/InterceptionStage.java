package com.github.supermoonie.type.network;


/**
 * Stages of the interception to begin intercepting. Request will intercept before the request is
sent. Response will intercept after the response is received.
 * 
 * @author supermoonie
 */
public enum InterceptionStage {

    /**
     * Request
     */
    Request("Request"),
    /**
     * HeadersReceived
     */
    HeadersReceived("HeadersReceived"),
    ;

    public final String value;

    InterceptionStage(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}