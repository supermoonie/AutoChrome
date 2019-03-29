package com.github.supermoonie.type.emulation;

/**
 * @author Administrator
 */
public enum PortraitType {
    /**
     * portraitPrimary
     */
    portraitPrimary("portraitPrimary"),
    /**
     * portraitSecondary
     */
    portraitSecondary("portraitSecondary"),
    /**
     * landscapePrimary
     */
    landscapePrimary("landscapePrimary"),
    /**
     * landscapeSecondary
     */
    landscapeSecondary("landscapeSecondary");

    public final String value;

    PortraitType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
