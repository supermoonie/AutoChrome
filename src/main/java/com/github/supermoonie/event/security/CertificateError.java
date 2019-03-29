package com.github.supermoonie.event.security;

import lombok.Data;

/**
 * There is a certificate error. If overriding certificate errors is enabled, then it should be
handled with the `handleCertificateError` command. Note: this event does not fire if the
certificate error has been allowed internally. Only one client per target should override
certificate errors at the same time.
 * 
 * @author supermoonie
 */ 
@Data
public class CertificateError {

    /**
     * The ID of the event.
     */
    private Integer eventId;

    /**
     * The type of the error.
     */
    private String errorType;

    /**
     * The url that was requested.
     */
    private String requestURL;

}