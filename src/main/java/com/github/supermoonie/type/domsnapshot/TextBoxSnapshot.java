package com.github.supermoonie.type.domsnapshot;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Details of post layout rendered text positions. The exact layout should not be regarded as
stable and may change between versions.
 * 
 * @author supermoonie
 */
@Data
public class TextBoxSnapshot {

    /**
     * Intex of th elayout tree node that owns this box collection.
     */
    private List<Integer> layoutIndex = new ArrayList<>();

    /**
     * The absolute position bounding box.
     */
    private List<List<Double>> bounds = new ArrayList<>();

    /**
     * The starting index in characters, for this post layout textbox substring. Characters that
would be represented as a surrogate pair in UTF-16 have length 2.
     */
    private List<Integer> start = new ArrayList<>();

    /**
     * The number of characters in this post layout textbox substring. Characters that would be
represented as a surrogate pair in UTF-16 have length 2.
     */
    private List<Integer> length = new ArrayList<>();

}