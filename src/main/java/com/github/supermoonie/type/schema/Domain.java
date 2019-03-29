package com.github.supermoonie.type.schema;

import lombok.Data;

/**
 * Description of the protocol domain.
 * 
 * @author supermoonie
 */
@Data
public class Domain {

    /**
     * Domain name.
     */
    private String name;

    /**
     * Domain version.
     */
    private String version;

}