package com.github.supermoonie.type.tracing;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class RequestMemoryDumpResult {
    private String dumpGuid;

    private Boolean success;

}
