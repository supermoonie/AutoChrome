package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired when the page with currently enabled screencast was shown or hidden `.
 * 
 * @author supermoonie
 */ 
@Data
public class ScreencastVisibilityChanged {

    /**
     * True if the page is visible.
     */
    private Boolean visible;

}