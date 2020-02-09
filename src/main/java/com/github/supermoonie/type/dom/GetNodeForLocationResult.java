package com.github.supermoonie.type.dom;

import lombok.Data;

/**
 * @author supermoonie
 * @since 2018/11/13
 */
@Data
public class GetNodeForLocationResult {

    /**
     * Resulting node.
     */
    private Integer backendNodeId;

    /**
     * Id of the node at given coordinates, only when enabled.
     */
    private Integer nodeId;

}
