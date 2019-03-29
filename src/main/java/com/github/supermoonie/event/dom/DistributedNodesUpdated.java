package com.github.supermoonie.event.dom;

import com.github.supermoonie.type.dom.BackendNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Called when distrubution is changed.
 * 
 * @author supermoonie
 */ 
@Data
public class DistributedNodesUpdated {

    /**
     * Insertion point where distrubuted nodes were updated.
     */
    private Integer insertionPointId;

    /**
     * Distributed nodes for given insertion point.
     */
    private List<BackendNode> distributedNodes = new ArrayList<>();

}