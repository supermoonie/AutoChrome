package com.github.supermoonie.type.serviceworker;


/**
 * @author supermoonie
 */
public enum ServiceWorkerVersionRunningStatus {

    /**
     * stopped
     */
    stopped("stopped"),
    /**
     * starting
     */
    starting("starting"),
    /**
     * running
     */
    running("running"),
    /**
     * stopping
     */
    stopping("stopping"),
    ;

    public final String value;

    ServiceWorkerVersionRunningStatus(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}