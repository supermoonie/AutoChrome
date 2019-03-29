package com.github.supermoonie.type.serviceworker;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ServiceWorker version.
 * 
 * @author supermoonie
 */
@Data
public class ServiceWorkerVersion {

    private String versionId;

    private String registrationId;

    private String scriptURL;

    private ServiceWorkerVersionRunningStatus runningStatus;

    private ServiceWorkerVersionStatus status;

    /**
     * The Last-Modified header value of the main script.
     */
    private Double scriptLastModified;

    /**
     * The time at which the response headers of the main script were received from the server.
For cached script it is the last time the cache entry was validated.
     */
    private Double scriptResponseTime;

    private List<String> controlledClients = new ArrayList<>();

    private String targetId;

}