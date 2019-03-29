package com.github.supermoonie.event.overlay;

import com.github.supermoonie.type.page.Viewport;
import lombok.Data;

/**
 * Fired when user asks to capture screenshot of some area on the page.
 * 
 * @author supermoonie
 */ 
@Data
public class ScreenshotRequested {

    /**
     * Viewport to capture, in CSS.
     */
    private Viewport viewport;

}