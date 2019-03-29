package com.github.supermoonie.type.dom;

import lombok.Data;

/**
 * Backend node with a friendly name.
 * 
 * @author supermoonie
 */
@Data
public class BackendNode {

    /**
     * `Node`'s nodeType.
     */
    private Integer nodeType;

    /**
     * `Node`'s nodeName.
     */
    private String nodeName;

    private Integer backendNodeId;

}