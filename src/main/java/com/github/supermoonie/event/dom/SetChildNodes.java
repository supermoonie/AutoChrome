package com.github.supermoonie.event.dom;

import com.github.supermoonie.type.dom.Node;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Fired when backend wants to provide client with the missing DOM structure. This happens upon
most of the calls requesting node ids.
 * 
 * @author supermoonie
 */ 
@Data
public class SetChildNodes {

    /**
     * Parent node id to populate with children.
     */
    private Integer parentId;

    /**
     * Child nodes array.
     */
    private List<Node> nodes = new ArrayList<>();

}