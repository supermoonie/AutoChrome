package com.github.supermoonie.type.input;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wangchao
 * @date 2018/11/22 21:38
 */
public enum KeyEventType {

    /**
     * keyDown
     */
    keyDown("keyDown"),

    /**
     * keyUp
     */
    keyUp("keyUp"),

    /**
     * rawKeyDown
     */
    rawKeyDown("rawKeyDown"),

    /**
     * char
     */
    @JSONField(name = "char")
    Char("char")
    ;

    private final String value;

    KeyEventType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
