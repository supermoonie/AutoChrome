package com.github.supermoonie.type.network;


/**
 * Network level fetch failure reason.
 * 
 * @author supermoonie
 */
public enum ErrorReason {

    /**
     * Failed
     */
    Failed("Failed"),
    /**
     * Aborted
     */
    Aborted("Aborted"),
    /**
     * TimedOut
     */
    TimedOut("TimedOut"),
    /**
     * AccessDenied
     */
    AccessDenied("AccessDenied"),
    /**
     * ConnectionClosed
     */
    ConnectionClosed("ConnectionClosed"),
    /**
     * ConnectionReset
     */
    ConnectionReset("ConnectionReset"),
    /**
     * ConnectionRefused
     */
    ConnectionRefused("ConnectionRefused"),
    /**
     * ConnectionAborted
     */
    ConnectionAborted("ConnectionAborted"),
    /**
     * ConnectionFailed
     */
    ConnectionFailed("ConnectionFailed"),
    /**
     * NameNotResolved
     */
    NameNotResolved("NameNotResolved"),
    /**
     * InternetDisconnected
     */
    InternetDisconnected("InternetDisconnected"),
    /**
     * AddressUnreachable
     */
    AddressUnreachable("AddressUnreachable"),
    /**
     * BlockedByClient
     */
    BlockedByClient("BlockedByClient"),
    /**
     * BlockedByResponse
     */
    BlockedByResponse("BlockedByResponse"),
    ;

    public final String value;

    ErrorReason(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}