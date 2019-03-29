package com.github.supermoonie.type.network;

/**
 * @author Administrator
 */
public enum AuthChallengeSource {
    /**
     * Server
     */
    Server("Server"),
    /**
     * Proxy
     */
    Proxy("Proxy");

    public final String value;

    AuthChallengeSource(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
