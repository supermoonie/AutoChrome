package com.github.supermoonie.type.network;

import lombok.Data;

/**
 * Information about a signed exchange response.
 * 
 * @author supermoonie
 */
@Data
public class SignedExchangeError {

    /**
     * Error message.
     */
    private String message;

    /**
     * The index of the signature which caused the error.
     */
    private Integer signatureIndex;

    /**
     * The field which caused the error.
     */
    private SignedExchangeErrorField errorField;

}