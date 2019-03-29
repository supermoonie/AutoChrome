package com.github.supermoonie.type.accessibility;

import lombok.Data;

/**
 * A single source for a computed AX property.
 * 
 * @author supermoonie
 */
@Data
public class AXValueSource {

    /**
     * What type of source this is.
     */
    private AXValueSourceType type;

    /**
     * The value of this property source.
     */
    private AXValue value;

    /**
     * The name of the relevant attribute, if any.
     */
    private String attribute;

    /**
     * The value of the relevant attribute, if any.
     */
    private AXValue attributeValue;

    /**
     * Whether this source is superseded by a higher priority source.
     */
    private Boolean superseded;

    /**
     * The native markup source for this value, e.g. a <label> element.
     */
    private AXValueNativeSourceType nativeSource;

    /**
     * The value, such as a node or node list, of the native source.
     */
    private AXValue nativeSourceValue;

    /**
     * Whether the value for this property is invalid.
     */
    private Boolean invalid;

    /**
     * Reason for the value being invalid, if it is.
     */
    private String invalidReason;

}