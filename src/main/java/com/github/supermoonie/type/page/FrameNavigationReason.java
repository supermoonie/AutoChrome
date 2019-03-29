package com.github.supermoonie.type.page;

/**
 * @author Administrator
 */
public enum FrameNavigationReason {
    /**
     * formSubmissionGet
     */
    formSubmissionGet("formSubmissionGet"),

    formSubmissionPost("formSubmissionPost"),

    httpHeaderRefresh("httpHeaderRefresh"),

    scriptInitiated("scriptInitiated"),

    metaTagRefresh("metaTagRefresh"),

    pageBlockInterstitial("pageBlockInterstitial"),

    reload("reload");

    public final String value;

    FrameNavigationReason(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
