package com.github.supermoonie.type.accessibility;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class AXProperty {

    /**
     * The name of this property.
     */
    private AXPropertyName name;

    /**
     * The value of this property.
     */
    private AXValue value;

}