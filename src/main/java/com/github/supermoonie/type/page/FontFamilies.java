package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * Generic font families collection.
 * 
 * @author supermoonie
 */
@Data
public class FontFamilies {

    /**
     * The standard font-family.
     */
    private String standard;

    /**
     * The fixed font-family.
     */
    private String fixed;

    /**
     * The serif font-family.
     */
    private String serif;

    /**
     * The sansSerif font-family.
     */
    private String sansSerif;

    /**
     * The cursive font-family.
     */
    private String cursive;

    /**
     * The fantasy font-family.
     */
    private String fantasy;

    /**
     * The pictograph font-family.
     */
    private String pictograph;

}