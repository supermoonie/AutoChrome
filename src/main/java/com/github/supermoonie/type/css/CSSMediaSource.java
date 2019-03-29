package com.github.supermoonie.type.css;

/**
 * @author Administrator
 */
public enum CSSMediaSource {
    /**
     * mediaRule
     */
    mediaRule("mediaRule"),
    /**
     * importRule
     */
    importRule("importRule"),
    /**
     * linkedSheet
     */
    linkedSheet("linkedSheet"),
    /**
     * inlineSheet
     */
    inlineSheet("inlineSheet");

    public final String value;

    CSSMediaSource(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
