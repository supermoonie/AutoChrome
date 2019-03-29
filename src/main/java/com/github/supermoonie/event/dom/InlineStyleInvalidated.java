package com.github.supermoonie.event.dom;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Fired when `Element`'s inline style is modified via a CSS property modification.
 * 
 * @author supermoonie
 */ 
@Data
public class InlineStyleInvalidated {

    /**
     * Ids of the nodes for which the inline styles have been invalidated.
     */
    private List<Integer> nodeIds = new ArrayList<>();

}