package com.github.supermoonie.type.input;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author supermoonie
 */
public enum GestureSourceType {

    /**
     * default
     */
    @JSONField(name = "default")
    Default("default"),
    /**
     * touch
     */
    touch("touch"),
    /**
     * mouse
     */
    mouse("mouse"),
    ;

    public final String value;

    GestureSourceType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}