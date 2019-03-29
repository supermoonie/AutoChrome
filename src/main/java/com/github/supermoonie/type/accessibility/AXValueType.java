package com.github.supermoonie.type.accessibility;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Enum of possible property types.
 * 
 * @author supermoonie
 */
public enum AXValueType {

    /**
     * boolean
     */
    @JSONField(name = "boolean")
    Boolean("boolean"),
    /**
     * tristate
     */
    tristate("tristate"),
    /**
     * booleanOrUndefined
     */
    booleanOrUndefined("booleanOrUndefined"),
    /**
     * idref
     */
    idref("idref"),
    /**
     * idrefList
     */
    idrefList("idrefList"),
    /**
     * integer
     */
    integer("integer"),
    /**
     * node
     */
    node("node"),
    /**
     * nodeList
     */
    nodeList("nodeList"),
    /**
     * number
     */
    number("number"),
    /**
     * string
     */
    string("string"),
    /**
     * computedString
     */
    computedString("computedString"),
    /**
     * token
     */
    token("token"),
    /**
     * tokenList
     */
    tokenList("tokenList"),
    /**
     * domRelation
     */
    domRelation("domRelation"),
    /**
     * role
     */
    role("role"),
    /**
     * internalRole
     */
    internalRole("internalRole"),
    /**
     * valueUndefined
     */
    valueUndefined("valueUndefined"),
    ;

    public final String value;

    AXValueType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}