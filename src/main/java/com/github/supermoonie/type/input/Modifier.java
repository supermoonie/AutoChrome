package com.github.supermoonie.type.input;

/**
 * @author wangchao
 * @date 2019/3/5 06:57
 */
public enum Modifier {
    /**
     * Alt
     */
    Alt(1),
    /**
     * Ctrl
     */
    Ctrl(2),
    /**
     * Meta
     */
    Meta(4),
    /**
     * Command
     */
    Command(4),
    /**
     * Shift
     */
    Shift(8),
    /**
     * Default
     */
    Default(0)
    ;

    private final int value;

    Modifier(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
