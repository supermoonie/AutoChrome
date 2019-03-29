package com.github.supermoonie.event.dom;

import lombok.Data;

/**
 * Called when shadow root is popped from the element.
 * 
 * @author supermoonie
 */ 
@Data
public class ShadowRootPopped {

    /**
     * Host element id.
     */
    private Integer hostId;

    /**
     * Shadow root id.
     */
    private Integer rootId;

}