package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
 * 
 * @author supermoonie
 */
@Data
public class FontFace {

    /**
     * The font-family.
     */
    private String fontFamily;

    /**
     * The font-style.
     */
    private String fontStyle;

    /**
     * The font-variant.
     */
    private String fontVariant;

    /**
     * The font-weight.
     */
    private String fontWeight;

    /**
     * The font-stretch.
     */
    private String fontStretch;

    /**
     * The unicode-range.
     */
    private String unicodeRange;

    /**
     * The src.
     */
    private String src;

    /**
     * The resolved platform font family
     */
    private String platformFontFamily;

}