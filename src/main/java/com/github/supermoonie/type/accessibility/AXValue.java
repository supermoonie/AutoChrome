package com.github.supermoonie.type.accessibility;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A single computed AX property.
 * 
 * @author supermoonie
 */
@Data
public class AXValue {

    /**
     * The type of this value.
     */
    private AXValueType type;

    /**
     * The computed value of this property.
     */
    private Object value;

    /**
     * One or more related nodes, if applicable.
     */
    private List<AXRelatedNode> relatedNodes = new ArrayList<>();

    /**
     * The sources which contributed to the computation of this property.
     */
    private List<AXValueSource> sources = new ArrayList<>();

}