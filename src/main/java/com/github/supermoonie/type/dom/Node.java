package com.github.supermoonie.type.dom;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes.
DOMNode is a base node mirror type.
 * 
 * @author supermoonie
 */
@Data
public class Node {

    /**
     * Node identifier that is passed into the rest of the DOM messages as the `nodeId`. Backend
will only push node with given `id` once. It is aware of all requested nodes and will only
fire DOM events for nodes known to the client.
     */
    private Integer nodeId;

    /**
     * The id of the parent node if any.
     */
    private Integer parentId;

    /**
     * The BackendNodeId for this node.
     */
    private Integer backendNodeId;

    /**
     * `Node`'s nodeType.
     */
    private Integer nodeType;

    /**
     * `Node`'s nodeName.
     */
    private String nodeName;

    /**
     * `Node`'s localName.
     */
    private String localName;

    /**
     * `Node`'s nodeValue.
     */
    private String nodeValue;

    /**
     * Child count for `Container` nodes.
     */
    private Integer childNodeCount;

    /**
     * Child nodes of this node when requested with children.
     */
    private List<Node> children = new ArrayList<>();

    /**
     * Attributes of the `Element` node in the form of flat array `[name1, value1, name2, value2]`.
     */
    private List<String> attributes = new ArrayList<>();

    /**
     * Document URL that `Document` or `FrameOwner` node points to.
     */
    private String documentURL;

    /**
     * Base URL that `Document` or `FrameOwner` node uses for URL completion.
     */
    private String baseURL;

    /**
     * `DocumentType`'s publicId.
     */
    private String publicId;

    /**
     * `DocumentType`'s systemId.
     */
    private String systemId;

    /**
     * `DocumentType`'s internalSubset.
     */
    private String internalSubset;

    /**
     * `Document`'s XML version in case of XML documents.
     */
    private String xmlVersion;

    /**
     * `Attr`'s name.
     */
    private String name;

    /**
     * `Attr`'s value.
     */
    private String value;

    /**
     * Pseudo element type for this node.
     */
    private PseudoType pseudoType;

    /**
     * Shadow root type.
     */
    private ShadowRootType shadowRootType;

    /**
     * Frame ID for frame owner elements.
     */
    private String frameId;

    /**
     * Content document for frame owner elements.
     */
    private Node contentDocument;

    /**
     * Shadow root list for given element host.
     */
    private List<Node> shadowRoots = new ArrayList<>();

    /**
     * Content document fragment for template elements.
     */
    private Node templateContent;

    /**
     * Pseudo elements associated with this node.
     */
    private List<Node> pseudoElements = new ArrayList<>();

    /**
     * Import document for the HTMLImport links.
     */
    private Node importedDocument;

    /**
     * Distributed nodes for given insertion point.
     */
    private List<BackendNode> distributedNodes = new ArrayList<>();

    /**
     * Whether the node is SVG.
     */
    private Boolean isSVG;

}