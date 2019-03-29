package com.github.supermoonie.type.serviceworker;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author supermoonie
 */
public enum ServiceWorkerVersionStatus {

    /**
     * new
     */
    @JSONField(name = "new")
    New("new"),
    /**
     * installing
     */
    installing("installing"),
    /**
     * installed
     */
    installed("installed"),
    /**
     * activating
     */
    activating("activating"),
    /**
     * activated
     */
    activated("activated"),
    /**
     * redundant
     */
    redundant("redundant"),
    ;

    public final String value;

    ServiceWorkerVersionStatus(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}