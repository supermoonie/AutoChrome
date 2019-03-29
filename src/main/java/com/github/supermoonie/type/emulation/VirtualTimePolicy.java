package com.github.supermoonie.type.emulation;


/**
 * advance: If the scheduler runs out of immediate work, the virtual time base may fast forward to
allow the next delayed task (if any) to run; pause: The virtual time base may not advance;
pauseIfNetworkFetchesPending: The virtual time base may not advance if there are any pending
resource fetches.
 * 
 * @author supermoonie
 */
public enum VirtualTimePolicy {

    /**
     * advance
     */
    advance("advance"),
    /**
     * pause
     */
    pause("pause"),
    /**
     * pauseIfNetworkFetchesPending
     */
    pauseIfNetworkFetchesPending("pauseIfNetworkFetchesPending"),
    ;

    public final String value;

    VirtualTimePolicy(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}