package com.github.supermoonie.event.dom;

import lombok.Data;

/**
 * Called when a pseudo element is removed from an element.
 * 
 * @author supermoonie
 */ 
@Data
public class PseudoElementRemoved {

    /**
     * Pseudo element's parent element id.
     */
    private Integer parentId;

    /**
     * The removed pseudo element id.
     */
    private Integer pseudoElementId;

}