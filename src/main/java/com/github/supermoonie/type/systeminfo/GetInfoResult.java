package com.github.supermoonie.type.systeminfo;

import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class GetInfoResult {
    private GPUInfo gpu;

    private String modelName;

    private String modelVersion;

    private String commandLine;

}
