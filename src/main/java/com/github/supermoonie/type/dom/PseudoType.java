package com.github.supermoonie.type.dom;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Pseudo element type
 *
 * @author wangchao
 */
public enum PseudoType {
    /**
     * first-line
     */
    @JSONField(name = "first-line")
    firstLine("first-line"),
    /**
     * first-letter
     */
    @JSONField(name = "first-letter")
    firstLetter("first-letter"),
    /**
     * before
     */
    before("before"),
    /**
     * after
     */
    after("after"),
    /**
     * backdrop
     */
    backdrop("backdrop"),
    /**
     * selection
     */
    selection("selection"),
    /**
     * first-line-inherited
     */
    @JSONField(name = "first-line-inherited")
    firstLineInherited("first-line-inherited"),
    /**
     * scrollbar
     */
    scrollbar("scrollbar"),
    /**
     * scrollbar-thumb
     */
    @JSONField(name = "scrollbar-thumb")
    scrollbarThumb("scrollbar-thumb"),
    /**
     * scrollbar-button
     */
    @JSONField(name = "scrollbar-button")
    scrollbarButton("scrollbar-button"),
    /**
     * scrollbar-track
     */
    @JSONField(name = "scrollbar-track")
    scrollbarTrack("scrollbar-track"),
    /**
     * scrollbar-track-piece
     */
    @JSONField(name = "scrollbar-track-piece")
    scrollbarTrackPiece("scrollbar-track-piece"),
    /**
     * scrollbar-corner
     */
    @JSONField(name = "scrollbar-corner")
    scrollbarCorner("scrollbar-corner"),
    /**
     * resizer
     */
    resizer("resizer"),
    /**
     * input-list-button
     */
    @JSONField(name = "input-list-button")
    inputListButton("input-list-button");

    public final String value;

    PseudoType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
