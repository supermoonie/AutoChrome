package com.github.supermoonie.type.io;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class ReadResult {
    private Boolean base64Encoded;

    private String data;

    private Boolean eof;

}
