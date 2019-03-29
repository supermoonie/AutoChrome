package com.github.supermoonie.event.serviceworker;

import com.github.supermoonie.type.serviceworker.ServiceWorkerVersion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author supermoonie
 */ 
@Data
public class WorkerVersionUpdated {

    private List<ServiceWorkerVersion> versions = new ArrayList<>();

}