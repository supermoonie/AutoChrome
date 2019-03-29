package com.github.supermoonie.event.overlay;

import lombok.Data;

/**
 * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
 * 
 * @author supermoonie
 */ 
@Data
public class NodeHighlightRequested {

    private Integer nodeId;

}