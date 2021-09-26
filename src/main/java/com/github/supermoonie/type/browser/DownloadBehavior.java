package com.github.supermoonie.type.browser;

/**
 * @author supermoonie
 * @since 2021/9/26
 */
public enum DownloadBehavior {
    /**
     * download behavior
     */
    DENY("deny"),
    ALLOW("allow"),
    ALLOW_AND_NAME("allowAndName"),
    DEFAULT("default");

    private final String value;

    DownloadBehavior(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
