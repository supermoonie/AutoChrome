package com.github.supermoonie.event.serviceworker;

import com.github.supermoonie.type.serviceworker.ServiceWorkerRegistration;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author supermoonie
 */ 
@Data
public class WorkerRegistrationUpdated {

    private List<ServiceWorkerRegistration> registrations = new ArrayList<>();

}