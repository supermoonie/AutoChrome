package com.github.supermoonie.event.heapprofiler;

import lombok.Data;

/**
 * @author supermoonie
 */ 
@Data
public class ReportHeapSnapshotProgress {

    private Integer done;

    private Integer total;

    private Boolean finished;

}