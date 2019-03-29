package com.github.supermoonie.command;

import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Experimental;
import com.github.supermoonie.annotation.Param;
import com.github.supermoonie.annotation.Returns;
import com.github.supermoonie.type.database.ExecuteSQLResult;

import java.util.List;

/**
 * @author Administrator
 */
@Experimental
@Domain("Database")
public interface Database {
    /**
     * Disables database tracking, prevents database events from being sent to the client.
     */
    void disable();

    /**
     * Enables database tracking, database events will now be delivered to the client.
     */
    void enable();

    /**
     * execute sql
     *
     * @param databaseId database id
     * @param query      query
     * @return ExecuteSQLResult result
     */
    ExecuteSQLResult executeSQL(@Param("databaseId") String databaseId, @Param("query") String query);

    /**
     * get database table names
     *
     * @param databaseId database id
     * @return table names
     */
    @Returns("tableNames")
    List<String> getDatabaseTableNames(@Param("databaseId") String databaseId);
}
