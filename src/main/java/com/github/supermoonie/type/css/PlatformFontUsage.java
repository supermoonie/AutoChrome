package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * Information about amount of glyphs that were rendered with given font.
 * 
 * @author supermoonie
 */
@Data
public class PlatformFontUsage {

    /**
     * Font's family name reported by platform.
     */
    private String familyName;

    /**
     * Indicates if the font was downloaded or resolved locally.
     */
    private Boolean isCustomFont;

    /**
     * Amount of glyphs that were rendered with this font.
     */
    private Double glyphCount;

}