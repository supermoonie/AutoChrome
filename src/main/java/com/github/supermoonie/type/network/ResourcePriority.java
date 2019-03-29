package com.github.supermoonie.type.network;


/**
 * Loading priority of a resource request.
 * 
 * @author supermoonie
 */
public enum ResourcePriority {

    /**
     * VeryLow
     */
    VeryLow("VeryLow"),
    /**
     * Low
     */
    Low("Low"),
    /**
     * Medium
     */
    Medium("Medium"),
    /**
     * High
     */
    High("High"),
    /**
     * VeryHigh
     */
    VeryHigh("VeryHigh"),
    ;

    public final String value;

    ResourcePriority(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}