package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * Information about the Frame on the page.
 * 
 * @author supermoonie
 */
@Data
public class Frame {

    /**
     * Frame unique identifier.
     */
    private String id;

    /**
     * Parent frame identifier.
     */
    private String parentId;

    /**
     * Identifier of the loader associated with this frame.
     */
    private String loaderId;

    /**
     * Frame's name as specified in the tag.
     */
    private String name;

    /**
     * Frame document's URL.
     */
    private String url;

    /**
     * Frame document's security origin.
     */
    private String securityOrigin;

    /**
     * Frame document's mimeType as determined by the browser.
     */
    private String mimeType;

    /**
     * If the frame failed to load, this contains the URL that could not be loaded.
     */
    private String unreachableUrl;

}