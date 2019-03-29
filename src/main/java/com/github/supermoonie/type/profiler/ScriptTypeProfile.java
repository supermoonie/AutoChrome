package com.github.supermoonie.type.profiler;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Type profile data collected during runtime for a JavaScript script.
 * 
 * @author supermoonie
 */
@Data
public class ScriptTypeProfile {

    /**
     * JavaScript script id.
     */
    private String scriptId;

    /**
     * JavaScript script name or url.
     */
    private String url;

    /**
     * Type profile entries for parameters and return values of the functions in the script.
     */
    private List<TypeProfileEntry> entries = new ArrayList<>();

}