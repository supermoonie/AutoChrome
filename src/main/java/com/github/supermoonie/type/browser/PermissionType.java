package com.github.supermoonie.type.browser;

/**
 * @author supermoonie
 */
public enum PermissionType {

    /**
     * accessibilityEvents
     */
    accessibilityEvents("accessibilityEvents"),
    /**
     * audioCapture
     */
    audioCapture("audioCapture"),
    /**
     * backgroundSync
     */
    backgroundSync("backgroundSync"),
    /**
     * backgroundFetch
     */
    backgroundFetch("backgroundFetch"),
    /**
     * clipboardRead
     */
    clipboardRead("clipboardRead"),
    /**
     * clipboardWrite
     */
    clipboardWrite("clipboardWrite"),
    /**
     * durableStorage
     */
    durableStorage("durableStorage"),
    /**
     * flash
     */
    flash("flash"),
    /**
     * geolocation
     */
    geolocation("geolocation"),
    /**
     * midi
     */
    midi("midi"),
    /**
     * midiSysex
     */
    midiSysex("midiSysex"),
    /**
     * notifications
     */
    notifications("notifications"),
    /**
     * paymentHandler
     */
    paymentHandler("paymentHandler"),
    /**
     * protectedMediaIdentifier
     */
    protectedMediaIdentifier("protectedMediaIdentifier"),
    /**
     * sensors
     */
    sensors("sensors"),
    /**
     * videoCapture
     */
    videoCapture("videoCapture"),
    ;

    public final String value;

    PermissionType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}