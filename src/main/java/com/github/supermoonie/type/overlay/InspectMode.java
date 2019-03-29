package com.github.supermoonie.type.overlay;


/**
 * @author supermoonie
 */
public enum InspectMode {

    /**
     * searchForNode
     */
    searchForNode("searchForNode"),
    /**
     * searchForUAShadowDOM
     */
    searchForUAShadowDOM("searchForUAShadowDOM"),
    /**
     * none
     */
    none("none"),
    ;

    public final String value;

    InspectMode(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}