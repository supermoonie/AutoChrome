package com.github.supermoonie.event.dom;

import lombok.Data;

/**
 * Mirrors `DOMCharacterDataModified` event.
 * 
 * @author supermoonie
 */ 
@Data
public class CharacterDataModified {

    /**
     * Id of the node that has changed.
     */
    private Integer nodeId;

    /**
     * New text value.
     */
    private String characterData;

}