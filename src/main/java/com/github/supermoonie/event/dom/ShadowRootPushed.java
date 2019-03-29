package com.github.supermoonie.event.dom;

import com.github.supermoonie.type.dom.Node;
import lombok.Data;

/**
 * Called when shadow root is pushed into the element.
 * 
 * @author supermoonie
 */ 
@Data
public class ShadowRootPushed {

    /**
     * Host element id.
     */
    private Integer hostId;

    /**
     * Shadow root.
     */
    private Node root;

}