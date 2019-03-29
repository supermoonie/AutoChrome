package com.github.supermoonie.type.css;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * CSS keyframes rule representation.
 * 
 * @author supermoonie
 */
@Data
public class CSSKeyframesRule {

    /**
     * Animation name.
     */
    private Value animationName;

    /**
     * List of keyframes.
     */
    private List<CSSKeyframeRule> keyframes = new ArrayList<>();

}