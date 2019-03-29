package com.github.supermoonie.type.tracing;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author supermoonie
 */
@Data
public class TraceConfig {

    /**
     * Controls how the trace buffer stores data.
     */
    private TraceRecordMode recordMode;

    /**
     * Turns on JavaScript stack sampling.
     */
    private Boolean enableSampling;

    /**
     * Turns on system tracing.
     */
    private Boolean enableSystrace;

    /**
     * Turns on argument filter.
     */
    private Boolean enableArgumentFilter;

    /**
     * Included category filters.
     */
    private List<String> includedCategories = new ArrayList<>();

    /**
     * Excluded category filters.
     */
    private List<String> excludedCategories = new ArrayList<>();

    /**
     * Configuration to synthesize the delays in tracing.
     */
    private List<String> syntheticDelays = new ArrayList<>();

    /**
     * Configuration for memory dump triggers. Used only when "memory-infra" category is enabled.
     */
    private MemoryDumpConfig memoryDumpConfig;

}