package com.github.supermoonie.type.fetch;

import lombok.Data;

/**
 * Response HTTP header entry
 * 
 * @author supermoonie
 */
@Data
public class HeaderEntry {

    private String name;

    private String value;

}