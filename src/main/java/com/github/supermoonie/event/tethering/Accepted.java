package com.github.supermoonie.event.tethering;

import lombok.Data;

/**
 * Informs that port was successfully bound and got a specified connection id.
 * 
 * @author supermoonie
 */ 
@Data
public class Accepted {

    /**
     * Port number that was successfully bound.
     */
    private Integer port;

    /**
     * Connection id to be used.
     */
    private String connectionId;

}