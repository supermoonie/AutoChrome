package com.github.supermoonie.event.css;

import com.github.supermoonie.type.css.CSSStyleSheetHeader;
import lombok.Data;

/**
 * Fired whenever an active document stylesheet is added.
 * 
 * @author supermoonie
 */ 
@Data
public class StyleSheetAdded {

    /**
     * Added stylesheet metainfo.
     */
    private CSSStyleSheetHeader header;

}