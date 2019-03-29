package com.github.supermoonie.type.accessibility;

/**
 * Enum of possible property sources.
 * 
 * @author supermoonie
 */
public enum AXValueSourceType {

    /**
     * attribute
     */
    attribute("attribute"),
    /**
     * implicit
     */
    implicit("implicit"),
    /**
     * style
     */
    style("style"),
    /**
     * contents
     */
    contents("contents"),
    /**
     * placeholder
     */
    placeholder("placeholder"),
    /**
     * relatedElement
     */
    relatedElement("relatedElement"),
    ;

    public final String value;

    AXValueSourceType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}