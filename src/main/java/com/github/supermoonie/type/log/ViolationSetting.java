package com.github.supermoonie.type.log;

import lombok.Data;

/**
 * Violation configuration setting.
 * 
 * @author supermoonie
 */
@Data
public class ViolationSetting {

    /**
     * Violation type.
     */
    private ViolationType name;

    /**
     * Time threshold to trigger upon.
     */
    private Double threshold;

}