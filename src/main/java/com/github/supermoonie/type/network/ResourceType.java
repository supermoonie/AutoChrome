package com.github.supermoonie.type.network;


/**
 * Resource type as it was perceived by the rendering engine.
 * 
 * @author supermoonie
 */
public enum ResourceType {

    /**
     * Document
     */
    Document("Document"),
    /**
     * Stylesheet
     */
    Stylesheet("Stylesheet"),
    /**
     * Image
     */
    Image("Image"),
    /**
     * Media
     */
    Media("Media"),
    /**
     * Font
     */
    Font("Font"),
    /**
     * Script
     */
    Script("Script"),
    /**
     * TextTrack
     */
    TextTrack("TextTrack"),
    /**
     * XHR
     */
    XHR("XHR"),
    /**
     * Fetch
     */
    Fetch("Fetch"),
    /**
     * EventSource
     */
    EventSource("EventSource"),
    /**
     * WebSocket
     */
    WebSocket("WebSocket"),
    /**
     * Manifest
     */
    Manifest("Manifest"),
    /**
     * SignedExchange
     */
    SignedExchange("SignedExchange"),
    /**
     * Ping
     */
    Ping("Ping"),
    /**
     * CSPViolationReport
     */
    CSPViolationReport("CSPViolationReport"),
    /**
     * Other
     */
    Other("Other"),
    ;

    public final String value;

    ResourceType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}