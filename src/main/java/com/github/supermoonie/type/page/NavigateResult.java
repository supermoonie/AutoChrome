package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class NavigateResult {
    private String frameId;

    private String loaderId;

    private String errorText;

}
