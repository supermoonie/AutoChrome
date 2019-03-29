package com.github.supermoonie.event.heapprofiler;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * If heap objects tracking has been started then backend may send update for one or more fragments
 * 
 * @author supermoonie
 */ 
@Data
public class HeapStatsUpdate {

    /**
     * An array of triplets. Each triplet describes a fragment. The first integer is the fragment
index, the second integer is a total count of objects for the fragment, the third integer is
a total size of the objects for the fragment.
     */
    private List<Integer> statsUpdate = new ArrayList<>();

}