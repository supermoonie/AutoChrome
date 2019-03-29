package com.github.supermoonie.type.input;

/**
 * @author wangchao
 * @date 2018/11/23 00:17
 */
public enum MouseButtonType {

    /**
     * none
     */
    none("none"),

    /**
     * left
     */
    left("left"),

    /**
     * middle
     */
    middle("middle"),

    /**
     * right
     */
    right("right")
    ;

    private final String value;

    MouseButtonType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
