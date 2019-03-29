package com.github.supermoonie.type.input;

/**
 * @author wangchao
 * @date 2018/11/23 00:14
 */
public enum MouseEventType {

    /**
     * mousePressed
     */
    mousePressed("mousePressed"),

    /**
     * mouseReleased
     */
    mouseReleased("mouseReleased"),

    /**
     * mouseMoved
     */
    mouseMoved("mouseMoved"),

    /**
     * mouseWheel
     */
    mouseWheel("mouseWheel")
    ;

    private final String value;

    MouseEventType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
