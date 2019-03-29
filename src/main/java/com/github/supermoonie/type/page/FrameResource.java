package com.github.supermoonie.type.page;

import com.github.supermoonie.type.network.ResourceType;
import lombok.Data;

/**
 * Information about the Resource on the page.
 * 
 * @author supermoonie
 */
@Data
public class FrameResource {

    /**
     * Resource URL.
     */
    private String url;

    /**
     * Type of this resource.
     */
    private ResourceType type;

    /**
     * Resource mimeType as determined by the browser.
     */
    private String mimeType;

    /**
     * last-modified timestamp as reported by server.
     */
    private Double lastModified;

    /**
     * Resource content size.
     */
    private Double contentSize;

    /**
     * True if the resource failed to load.
     */
    private Boolean failed;

    /**
     * True if the resource was canceled during loading.
     */
    private Boolean canceled;

}