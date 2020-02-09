package com.github.supermoonie.type.page;

/**
 * @author wangchao
 * @since 2018/12/1 11:56
 */
public enum LifecycleEventType {
    /**
     * networkAlmostIdle
     */
    networkAlmostIdle("networkAlmostIdle"),

    /**
     * firstMeaningfulPaint
     */
    firstMeaningfulPaint("firstMeaningfulPaint"),

    /**
     * networkIdle
     */
    networkIdle("networkIdle");

    private final String value;

    LifecycleEventType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
