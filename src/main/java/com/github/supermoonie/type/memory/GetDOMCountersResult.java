package com.github.supermoonie.type.memory;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class GetDOMCountersResult {
    private Integer documents;

    private Integer nodes;

    private Integer jsEventListeners;

}
