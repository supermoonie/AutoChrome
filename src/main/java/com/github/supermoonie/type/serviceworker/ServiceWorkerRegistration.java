package com.github.supermoonie.type.serviceworker;

import lombok.Data;

/**
 * ServiceWorker registration.
 * 
 * @author supermoonie
 */
@Data
public class ServiceWorkerRegistration {

    private String registrationId;

    private String scopeURL;

    private Boolean isDeleted;

}