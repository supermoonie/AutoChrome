package com.github.supermoonie.type.accessibility;

/**
 * Enum of possible native property sources (as a subtype of a particular AXValueSourceType).
 * 
 * @author supermoonie
 */
public enum AXValueNativeSourceType {

    /**
     * figcaption
     */
    figcaption("figcaption"),
    /**
     * label
     */
    label("label"),
    /**
     * labelfor
     */
    labelfor("labelfor"),
    /**
     * labelwrapped
     */
    labelwrapped("labelwrapped"),
    /**
     * legend
     */
    legend("legend"),
    /**
     * tablecaption
     */
    tablecaption("tablecaption"),
    /**
     * title
     */
    title("title"),
    /**
     * other
     */
    other("other"),
    ;

    public final String value;

    AXValueNativeSourceType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}