package com.github.supermoonie.type.profiler;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Profile.
 * 
 * @author supermoonie
 */
@Data
public class Profile {

    /**
     * The list of profile nodes. First item is the root node.
     */
    private List<ProfileNode> nodes = new ArrayList<>();

    /**
     * Profiling start timestamp in microseconds.
     */
    private Double startTime;

    /**
     * Profiling end timestamp in microseconds.
     */
    private Double endTime;

    /**
     * Ids of samples top nodes.
     */
    private List<Integer> samples = new ArrayList<>();

    /**
     * Time intervals between adjacent samples in microseconds. The first delta is relative to the
profile startTime.
     */
    private List<Integer> timeDeltas = new ArrayList<>();

}