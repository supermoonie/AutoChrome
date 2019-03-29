package com.github.supermoonie.event.css;

import lombok.Data;

/**
 * Fired whenever an active document stylesheet is removed.
 * 
 * @author supermoonie
 */ 
@Data
public class StyleSheetRemoved {

    /**
     * Identifier of the removed stylesheet.
     */
    private String styleSheetId;

}