package com.github.supermoonie.type.database;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ExecuteSQLResult {

    private List<String> columnNames;

    private List<Object> values;

    private Error sqlError;

}
