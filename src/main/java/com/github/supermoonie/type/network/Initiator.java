package com.github.supermoonie.type.network;

import com.github.supermoonie.type.runtime.StackTrace;
import lombok.Data;

/**
 * Information about the request initiator.
 * 
 * @author supermoonie
 */
@Data
public class Initiator {

    /**
     * Type of this initiator.
     */
    private String type;

    /**
     * Initiator JavaScript stack trace, set for Script only.
     */
    private StackTrace stack;

    /**
     * Initiator URL, set for Parser type or for Script type (when script is importing module) or for SignedExchange type.
     */
    private String url;

    /**
     * Initiator line number, set for Parser type or for Script type (when script is importing
module) (0-based).
     */
    private Double lineNumber;

}