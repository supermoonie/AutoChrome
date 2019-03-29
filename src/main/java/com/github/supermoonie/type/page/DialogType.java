package com.github.supermoonie.type.page;


/**
 * Javascript dialog type.
 * 
 * @author supermoonie
 */
public enum DialogType {

    /**
     * alert
     */
    alert("alert"),
    /**
     * confirm
     */
    confirm("confirm"),
    /**
     * prompt
     */
    prompt("prompt"),
    /**
     * beforeunload
     */
    beforeunload("beforeunload"),
    ;

    public final String value;

    DialogType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}