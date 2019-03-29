package com.github.supermoonie.event.tracing;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
 * 
 * @author supermoonie
 */ 
@Data
public class DataCollected {

    private List<Object> value = new ArrayList<>();

}