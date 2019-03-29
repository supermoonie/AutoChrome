package com.github.supermoonie.type.domsnapshot;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A subset of the full ComputedStyle as defined by the request whitelist.
 * 
 * @author supermoonie
 */
@Data
public class ComputedStyle {

    /**
     * Name/value pairs of computed style properties.
     */
    private List<NameValue> properties = new ArrayList<>();

}