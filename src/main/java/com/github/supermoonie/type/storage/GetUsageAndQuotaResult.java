package com.github.supermoonie.type.storage;

import lombok.Data;

import java.util.List;

/**
 * @author wangchao
 */
@Data
public class GetUsageAndQuotaResult {

    /**
     * Storage usage (bytes).
     */
    private Double usage;

    /**
     * Storage quota (bytes).
     */
    private Double quota;

    /**
     * Storage usage per type (bytes).
     */
    private List<UsageForType> usageBreakdown;

}
