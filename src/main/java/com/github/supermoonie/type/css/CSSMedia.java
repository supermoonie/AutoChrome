package com.github.supermoonie.type.css;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * CSS media rule descriptor.
 * 
 * @author supermoonie
 */
@Data
public class CSSMedia {

    /**
     * Media query text.
     */
    private String text;

    /**
     * Source of the media query: "mediaRule" if specified by a @media rule, "importRule" if
specified by an @import rule, "linkedSheet" if specified by a "media" attribute in a linked
stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline
stylesheet's STYLE tag.
     */
    private CSSMediaSource source;

    /**
     * URL of the document containing the media query description.
     */
    private String sourceURL;

    /**
     * The associated rule (@media or @import) header range in the enclosing stylesheet (if
available).
     */
    private SourceRange range;

    /**
     * Identifier of the stylesheet containing this object (if exists).
     */
    private String styleSheetId;

    /**
     * Array of media queries.
     */
    private List<MediaQuery> mediaList = new ArrayList<>();

}