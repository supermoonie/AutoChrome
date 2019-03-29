package com.github.supermoonie.type.audits;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class GetEncodedResponseResult {

    /**
     * The encoded body as a base64 string. Omitted if sizeOnly is true.
     */
    private String body;

    /**
     * Size before re-encoding.
     */
    private Integer originalSize;

    /**
     * Size after re-encoding.
     */
    private Integer encodedSize;

}
