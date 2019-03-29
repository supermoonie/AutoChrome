package com.github.supermoonie.type.indexeddb;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Key path.
 * 
 * @author supermoonie
 */
@Data
public class KeyPath {

    /**
     * Key path type.
     */
    private String type;

    /**
     * String value.
     */
    private String string;

    /**
     * Array value.
     */
    private List<String> array = new ArrayList<>();

}