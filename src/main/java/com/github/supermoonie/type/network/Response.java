package com.github.supermoonie.type.network;

import com.github.supermoonie.type.security.SecurityState;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP response data.
 *
 * @author supermoonie
 */
@Data
public class Response {

    /**
     * Response URL. This URL can be different from CachedResource.url in case of redirect.
     */
    private String url;

    /**
     * HTTP response status code.
     */
    private Integer status;

    /**
     * HTTP response status text.
     */
    private String statusText;

    /**
     * HTTP response headers.
     */
    private Map<String, Object> headers = new HashMap<>();

    /**
     * HTTP response headers text.
     */
    private String headersText;

    /**
     * Resource mimeType as determined by the browser.
     */
    private String mimeType;

    /**
     * Refined HTTP request headers that were actually transmitted over the network.
     */
    private Map<String, Object> requestHeaders = new HashMap<>();

    /**
     * HTTP request headers text.
     */
    private String requestHeadersText;

    /**
     * Specifies whether physical connection was actually reused for this request.
     */
    private Boolean connectionReused;

    /**
     * Physical connection id that was actually used for this request.
     */
    private Double connectionId;

    /**
     * Remote IP address.
     */
    private String remoteIPAddress;

    /**
     * Remote port.
     */
    private Integer remotePort;

    /**
     * Specifies that the request was served from the disk cache.
     */
    private Boolean fromDiskCache;

    /**
     * Specifies that the request was served from the ServiceWorker.
     */
    private Boolean fromServiceWorker;

    /**
     * Total number of bytes received for this request so far.
     */
    private Double encodedDataLength;

    /**
     * Timing information for the given request.
     */
    private ResourceTiming timing;

    /**
     * Protocol used to fetch this request.
     */
    private String protocol;

    /**
     * Security state of the request resource.
     */
    private SecurityState securityState;

    /**
     * Security details for the request.
     */
    private SecurityDetails securityDetails;

}