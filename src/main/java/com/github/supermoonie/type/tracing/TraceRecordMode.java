package com.github.supermoonie.type.tracing;

/**
 * @author wangchao
 */
public enum TraceRecordMode {
    /**
     * recordUntilFull
     */
    recordUntilFull("recordUntilFull"),

    recordContinuously("recordContinuously"),

    recordAsMuchAsPossible("recordAsMuchAsPossible"),

    echoToConsole("echoToConsole");

    public final String value;

    TraceRecordMode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
