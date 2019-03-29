package com.github.supermoonie.event.dom;

import com.github.supermoonie.type.dom.Node;
import lombok.Data;

/**
 * Called when a pseudo element is added to an element.
 * 
 * @author supermoonie
 */ 
@Data
public class PseudoElementAdded {

    /**
     * Pseudo element's parent element id.
     */
    private Integer parentId;

    /**
     * The added pseudo element.
     */
    private Node pseudoElement;

}