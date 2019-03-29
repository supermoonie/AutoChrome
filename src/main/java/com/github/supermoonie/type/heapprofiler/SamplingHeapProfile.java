package com.github.supermoonie.type.heapprofiler;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Sampling profile.
 * 
 * @author supermoonie
 */
@Data
public class SamplingHeapProfile {

    private SamplingHeapProfileNode head;

    private List<SamplingHeapProfileSample> samples = new ArrayList<>();

}