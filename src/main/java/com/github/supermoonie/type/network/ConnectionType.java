package com.github.supermoonie.type.network;


/**
 * The underlying connection technology that the browser is supposedly using.
 * 
 * @author supermoonie
 */
public enum ConnectionType {

    /**
     * none
     */
    none("none"),
    /**
     * cellular2g
     */
    cellular2g("cellular2g"),
    /**
     * cellular3g
     */
    cellular3g("cellular3g"),
    /**
     * cellular4g
     */
    cellular4g("cellular4g"),
    /**
     * bluetooth
     */
    bluetooth("bluetooth"),
    /**
     * ethernet
     */
    ethernet("ethernet"),
    /**
     * wifi
     */
    wifi("wifi"),
    /**
     * wimax
     */
    wimax("wimax"),
    /**
     * other
     */
    other("other"),
    ;

    public final String value;

    ConnectionType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}