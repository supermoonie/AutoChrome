package com.github.supermoonie.type.memory;


/**
 * Memory pressure level.
 * 
 * @author supermoonie
 */
public enum PressureLevel {

    /**
     * moderate
     */
    moderate("moderate"),
    /**
     * critical
     */
    critical("critical"),
    ;

    public final String value;

    PressureLevel(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}