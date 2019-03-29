package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * A descriptor of operation to mutate style declaration text.
 * 
 * @author supermoonie
 */
@Data
public class StyleDeclarationEdit {

    /**
     * The css style sheet identifier.
     */
    private String styleSheetId;

    /**
     * The range of the style text in the enclosing stylesheet.
     */
    private SourceRange range;

    /**
     * New style text.
     */
    private String text;

}