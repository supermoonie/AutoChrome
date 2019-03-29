package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class GetHeapUsageResult {
    /**
     * Used heap size in bytes.
     */
    private Double usedSize;

    /**
     * Allocated heap size in bytes.
     */
    private Double totalSize;

}
