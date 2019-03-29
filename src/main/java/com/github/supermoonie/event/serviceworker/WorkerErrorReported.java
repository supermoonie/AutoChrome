package com.github.supermoonie.event.serviceworker;

import com.github.supermoonie.type.serviceworker.ServiceWorkerErrorMessage;
import lombok.Data;

/**
 * @author supermoonie
 */ 
@Data
public class WorkerErrorReported {

    private ServiceWorkerErrorMessage errorMessage;

}