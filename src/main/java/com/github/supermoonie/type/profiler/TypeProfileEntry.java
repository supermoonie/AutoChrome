package com.github.supermoonie.type.profiler;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Source offset and types for a parameter or return value.
 * 
 * @author supermoonie
 */
@Data
public class TypeProfileEntry {

    /**
     * Source offset of the parameter or end of function for return values.
     */
    private Integer offset;

    /**
     * The types for this parameter or return value.
     */
    private List<TypeObject> types = new ArrayList<>();

}