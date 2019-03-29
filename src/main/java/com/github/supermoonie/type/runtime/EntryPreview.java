package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class EntryPreview {

    /**
     * Preview of the key. Specified for map-like collection entries.
     */
    private ObjectPreview key;

    /**
     * Preview of the value.
     */
    private ObjectPreview value;

}