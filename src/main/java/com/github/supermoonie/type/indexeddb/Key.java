package com.github.supermoonie.type.indexeddb;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Key.
 * 
 * @author supermoonie
 */
@Data
public class Key {

    /**
     * Key type.
     */
    private String type;

    /**
     * Number value.
     */
    private Double number;

    /**
     * String value.
     */
    private String string;

    /**
     * Date value.
     */
    private Double date;

    /**
     * Array value.
     */
    private List<Key> array = new ArrayList<>();

}