package com.github.supermoonie.type.page;


/**
 * Transition type.
 * 
 * @author supermoonie
 */
public enum TransitionType {

    /**
     * link
     */
    link("link"),
    /**
     * typed
     */
    typed("typed"),
    /**
     * address_bar
     */
    address_bar("address_bar"),
    /**
     * auto_bookmark
     */
    auto_bookmark("auto_bookmark"),
    /**
     * auto_subframe
     */
    auto_subframe("auto_subframe"),
    /**
     * manual_subframe
     */
    manual_subframe("manual_subframe"),
    /**
     * generated
     */
    generated("generated"),
    /**
     * auto_toplevel
     */
    auto_toplevel("auto_toplevel"),
    /**
     * form_submit
     */
    form_submit("form_submit"),
    /**
     * reload
     */
    reload("reload"),
    /**
     * keyword
     */
    keyword("keyword"),
    /**
     * keyword_generated
     */
    keyword_generated("keyword_generated"),
    /**
     * other
     */
    other("other"),
    ;

    public final String value;

    TransitionType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}