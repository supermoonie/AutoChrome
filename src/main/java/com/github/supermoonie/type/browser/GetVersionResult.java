package com.github.supermoonie.type.browser;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class GetVersionResult {

    /**
     * Protocol version.
     */
    private String protocolVersion;

    /**
     * Product name.
     */
    private String product;

    /**
     * Product revision.
     */
    private String revision;

    /**
     * User-Agent.
     */
    private String userAgent;

    /**
     * V8 version.
     */
    private String jsVersion;

}
