package com.github.supermoonie.type.fetch;


/**
 * Stages of the request to handle. Request will intercept before the request is
sent. Response will intercept after the response is received (but before response
body is received.
 * 
 * @author supermoonie
 */
public enum RequestStage {

    /**
     * Request
     */
    Request("Request"),
    /**
     * Response
     */
    Response("Response"),
    ;

    public final String value;

    RequestStage(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}