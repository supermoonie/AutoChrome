package com.github.supermoonie.type.systeminfo;

import lombok.Data;

/**
 * Represents process info.
 * 
 * @author supermoonie
 */
@Data
public class ProcessInfo {

    /**
     * Specifies process type.
     */
    private String type;

    /**
     * Specifies process id.
     */
    private Integer id;

    /**
     * Specifies cumulative CPU usage in seconds across all threads of the
process since the process start.
     */
    private Double cpuTime;

}