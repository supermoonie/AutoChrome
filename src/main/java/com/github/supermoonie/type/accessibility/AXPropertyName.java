package com.github.supermoonie.type.accessibility;

/**
 * Values of AXProperty name: from 'busy' to 'roledescription' - states which apply to every AX
node, from 'live' to 'root' - attributes which apply to nodes in live regions, from
'autocomplete' to 'valuetext' - attributes which apply to widgets, from 'checked' to 'selected'
- states which apply to widgets, from 'activedescendant' to 'owns' - relationships between
elements other than parent/child/sibling.
 * 
 * @author supermoonie
 */
public enum AXPropertyName {

    /**
     * busy
     */
    busy("busy"),
    /**
     * disabled
     */
    disabled("disabled"),
    /**
     * editable
     */
    editable("editable"),
    /**
     * focusable
     */
    focusable("focusable"),
    /**
     * focused
     */
    focused("focused"),
    /**
     * hidden
     */
    hidden("hidden"),
    /**
     * hiddenRoot
     */
    hiddenRoot("hiddenRoot"),
    /**
     * invalid
     */
    invalid("invalid"),
    /**
     * keyshortcuts
     */
    keyshortcuts("keyshortcuts"),
    /**
     * settable
     */
    settable("settable"),
    /**
     * roledescription
     */
    roledescription("roledescription"),
    /**
     * live
     */
    live("live"),
    /**
     * atomic
     */
    atomic("atomic"),
    /**
     * relevant
     */
    relevant("relevant"),
    /**
     * root
     */
    root("root"),
    /**
     * autocomplete
     */
    autocomplete("autocomplete"),
    /**
     * hasPopup
     */
    hasPopup("hasPopup"),
    /**
     * level
     */
    level("level"),
    /**
     * multiselectable
     */
    multiselectable("multiselectable"),
    /**
     * orientation
     */
    orientation("orientation"),
    /**
     * multiline
     */
    multiline("multiline"),
    /**
     * readonly
     */
    readonly("readonly"),
    /**
     * required
     */
    required("required"),
    /**
     * valuemin
     */
    valuemin("valuemin"),
    /**
     * valuemax
     */
    valuemax("valuemax"),
    /**
     * valuetext
     */
    valuetext("valuetext"),
    /**
     * checked
     */
    checked("checked"),
    /**
     * expanded
     */
    expanded("expanded"),
    /**
     * modal
     */
    modal("modal"),
    /**
     * pressed
     */
    pressed("pressed"),
    /**
     * selected
     */
    selected("selected"),
    /**
     * activedescendant
     */
    activedescendant("activedescendant"),
    /**
     * controls
     */
    controls("controls"),
    /**
     * describedby
     */
    describedby("describedby"),
    /**
     * details
     */
    details("details"),
    /**
     * errormessage
     */
    errormessage("errormessage"),
    /**
     * flowto
     */
    flowto("flowto"),
    /**
     * labelledby
     */
    labelledby("labelledby"),
    /**
     * owns
     */
    owns("owns"),
    ;

    public final String value;

    AXPropertyName(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}