package com.github.supermoonie.type.profiler;

import lombok.Data;

/**
 * Describes a type collected during runtime.
 * 
 * @author supermoonie
 */
@Data
public class TypeObject {

    /**
     * Name of a type collected with type profiling.
     */
    private String name;

}