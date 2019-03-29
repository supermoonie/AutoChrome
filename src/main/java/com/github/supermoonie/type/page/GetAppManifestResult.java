package com.github.supermoonie.type.page;

import lombok.Data;

import java.util.List;

/**
 * @author wangchao
 */
@Data
public class GetAppManifestResult {
    private String url;

    private List<AppManifestError> errors;

    private String data;

}
