package com.github.supermoonie.type.tracing;


/**
 * Compression type to use for traces returned via streams.
 * 
 * @author supermoonie
 */
public enum StreamCompression {

    /**
     * none
     */
    none("none"),
    /**
     * gzip
     */
    gzip("gzip"),
    ;

    public final String value;

    StreamCompression(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}