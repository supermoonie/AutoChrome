package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
 * 
 * @author supermoonie
 */ 
@Data
public class NavigatedWithinDocument {

    /**
     * Id of the frame.
     */
    private String frameId;

    /**
     * Frame's new url.
     */
    private String url;

}