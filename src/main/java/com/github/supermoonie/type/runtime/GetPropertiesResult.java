package com.github.supermoonie.type.runtime;

import lombok.Data;

import java.util.List;

/**
 * @author wangchao
 */
@Data
public class GetPropertiesResult {
    /**
     * Object properties.
     */
    private List<PropertyDescriptor> result;

    /**
     * Internal object properties (only of the element itself).
     */
    private List<InternalPropertyDescriptor> internalProperties;

    /**
     * Exception details.
     */
    private ExceptionDetails exceptionDetails;

}
