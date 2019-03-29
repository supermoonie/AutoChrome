package com.github.supermoonie.type.network;


/**
 * Field type for a signed exchange related error.
 * 
 * @author supermoonie
 */
public enum SignedExchangeErrorField {

    /**
     * signatureSig
     */
    signatureSig("signatureSig"),
    /**
     * signatureIntegrity
     */
    signatureIntegrity("signatureIntegrity"),
    /**
     * signatureCertUrl
     */
    signatureCertUrl("signatureCertUrl"),
    /**
     * signatureCertSha256
     */
    signatureCertSha256("signatureCertSha256"),
    /**
     * signatureValidityUrl
     */
    signatureValidityUrl("signatureValidityUrl"),
    /**
     * signatureTimestamps
     */
    signatureTimestamps("signatureTimestamps"),
    ;

    public final String value;

    SignedExchangeErrorField(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}