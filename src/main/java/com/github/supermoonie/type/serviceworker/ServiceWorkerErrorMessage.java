package com.github.supermoonie.type.serviceworker;

import lombok.Data;

/**
 * ServiceWorker error message.
 * 
 * @author supermoonie
 */
@Data
public class ServiceWorkerErrorMessage {

    private String errorMessage;

    private String registrationId;

    private String versionId;

    private String sourceURL;

    private Integer lineNumber;

    private Integer columnNumber;

}