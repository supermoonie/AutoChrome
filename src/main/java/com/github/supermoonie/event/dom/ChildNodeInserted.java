package com.github.supermoonie.event.dom;

import com.github.supermoonie.type.dom.Node;
import lombok.Data;

/**
 * Mirrors `DOMNodeInserted` event.
 * 
 * @author supermoonie
 */ 
@Data
public class ChildNodeInserted {

    /**
     * Id of the node that has changed.
     */
    private Integer parentNodeId;

    /**
     * If of the previous siblint.
     */
    private Integer previousNodeId;

    /**
     * Inserted node data.
     */
    private Node node;

}