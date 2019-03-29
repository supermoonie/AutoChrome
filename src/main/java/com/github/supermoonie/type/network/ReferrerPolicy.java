package com.github.supermoonie.type.network;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wangchao
 */
public enum ReferrerPolicy {
    /**
     * unsafe-url
     */
    @JSONField(name = "unsafe-url")
    unsafeUrl("unsafe-url"),
    /**
     * no-referrer-when-downgrade
     */
    @JSONField(name = "no-referrer-when-downgrade")
    noReferrerWhenDowngrade("no-referrer-when-downgrade"),
    /**
     * no-referrer
     */
    @JSONField(name = "no-referrer")
    noReferrer("no-referrer"),
    /**
     * origin
     */
    origin("origin"),
    /**
     * origin-when-cross-origin
     */
    originWhenCrossOrigin("origin-when-cross-origin"),
    /**
     * same-origin
     */
    @JSONField(name = "same-origin")
    sameOrigin("same-origin"),
    /**
     * strict-origin
     */
    @JSONField(name = "strict-origin")
    strictOrigin("strict-origin"),
    /**
     * strict-origin-when-cross-origin
     */
    @JSONField(name = "strict-origin-when-cross-origin")
    StrictOriginWhenCrossOrigin("strict-origin-when-cross-origin");

    public final String value;

    ReferrerPolicy(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
