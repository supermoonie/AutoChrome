package com.github.supermoonie.event.css;

import com.github.supermoonie.type.css.FontFace;
import lombok.Data;

/**
 * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
 * 
 * @author supermoonie
 */ 
@Data
public class FontsUpdated {

    /**
     * The web font that has loaded.
     */
    private FontFace font;

}