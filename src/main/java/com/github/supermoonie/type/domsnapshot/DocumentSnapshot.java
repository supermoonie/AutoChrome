package com.github.supermoonie.type.domsnapshot;

import lombok.Data;

/**
 * Document snapshot.
 * 
 * @author supermoonie
 */
@Data
public class DocumentSnapshot {

    /**
     * Document URL that `Document` or `FrameOwner` node points to.
     */
    private Integer documentURL;

    /**
     * Base URL that `Document` or `FrameOwner` node uses for URL completion.
     */
    private Integer baseURL;

    /**
     * Contains the document's content language.
     */
    private Integer contentLanguage;

    /**
     * Contains the document's character set encoding.
     */
    private Integer encodingName;

    /**
     * `DocumentType` node's publicId.
     */
    private Integer publicId;

    /**
     * `DocumentType` node's systemId.
     */
    private Integer systemId;

    /**
     * Frame ID for frame owner elements and also for the document node.
     */
    private Integer frameId;

    /**
     * A table with dom nodes.
     */
    private NodeTreeSnapshot nodes;

    /**
     * The nodes in the layout tree.
     */
    private LayoutTreeSnapshot layout;

    /**
     * The post-layout inline text nodes.
     */
    private TextBoxSnapshot textBoxes;

    /**
     * Scroll offsets.
     */
    private Double scrollOffsetX;

    private Double scrollOffsetY;

}