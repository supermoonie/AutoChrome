package com.github.supermoonie.type.headlessexperimental;

/**
 * @author Administrator
 */
public enum ImageFormat {
    /**
     * jpeg
     */
    jpeg("jpeg"),
    /**
     * png
     */
    png("png");

    public final String value;

    ImageFormat(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
