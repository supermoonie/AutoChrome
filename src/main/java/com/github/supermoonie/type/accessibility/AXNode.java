package com.github.supermoonie.type.accessibility;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A node in the accessibility tree.
 * 
 * @author supermoonie
 */
@Data
public class AXNode {

    /**
     * Unique identifier for this node.
     */
    private String nodeId;

    /**
     * Whether this node is ignored for accessibility
     */
    private Boolean ignored;

    /**
     * Collection of reasons why this node is hidden.
     */
    private List<AXProperty> ignoredReasons = new ArrayList<>();

    /**
     * This `Node`'s role, whether explicit or implicit.
     */
    private AXValue role;

    /**
     * The accessible name for this `Node`.
     */
    private AXValue name;

    /**
     * The accessible description for this `Node`.
     */
    private AXValue description;

    /**
     * The value for this `Node`.
     */
    private AXValue value;

    /**
     * All other properties
     */
    private List<AXProperty> properties = new ArrayList<>();

    /**
     * IDs for each of this node's child nodes.
     */
    private List<String> childIds = new ArrayList<>();

    /**
     * The backend ID for the associated DOM node, if any.
     */
    private Integer backendDOMNodeId;

}