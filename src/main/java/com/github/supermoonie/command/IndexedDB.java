package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.indexeddb.DatabaseWithObjectStores;
import com.github.supermoonie.type.indexeddb.KeyRange;
import com.github.supermoonie.type.indexeddb.RequestDataResult;

import java.util.List;

/**
 * @author supermoonie
 * @since 2018/11/14
 */
@Experimental
@Domain("IndexedDB")
public interface IndexedDB {

    /**
     * Clears all entries from an object store.
     *
     * @param securityOrigin  Security origin.
     * @param databaseName    Database name.
     * @param objectStoreName Object store name.
     */
    void clearObjectStore(@Param("securityOrigin") String securityOrigin,
                          @Param("databaseName") String databaseName,
                          @Param("objectStoreName") String objectStoreName);

    /**
     * Deletes a database.
     *
     * @param securityOrigin Security origin.
     * @param databaseName   Database name.
     */
    void deleteDatabase(@Param("securityOrigin") String securityOrigin,
                        @Param("databaseName") String databaseName);

    /**
     * Delete a range of entries from an object store
     *
     * @param securityOrigin  Security origin.
     * @param databaseName    Database name.
     * @param objectStoreName Object store name.
     * @param keyRange        Range of entry keys to delete
     */
    void deleteObjectStoreEntries(@Param("securityOrigin") String securityOrigin,
                                  @Param("databaseName") String databaseName,
                                  @Param("objectStoreName") String objectStoreName,
                                  @Param("keyRange") KeyRange keyRange);

    /**
     * Disables events from backend.
     */
    void disable();

    /**
     * Enables events from backend.
     */
    void enable();

    /**
     * Requests data from object store or index.
     *
     * @param securityOrigin  Security origin.
     * @param databaseName    Database name.
     * @param objectStoreName Object store name.
     * @param indexName       Index name, empty string for object store data requests.
     * @param skipCount       Number of records to skip.
     * @param pageSize        Number of records to fetch.
     * @param keyRange        Key range.
     * @return RequestDataResult
     */
    RequestDataResult requestData(@Param("securityOrigin") String securityOrigin,
                                  @Param("databaseName") String databaseName,
                                  @Param("objectStoreName") String objectStoreName,
                                  @Param("indexName") String indexName,
                                  @Param("skipCount") int skipCount,
                                  @Param("pageSize") int pageSize,
                                  @Param("keyRange") @Optional KeyRange keyRange);

    /**
     * Requests database with given name in given frame.
     *
     * @param securityOrigin Security origin.
     * @param databaseName   Database name.
     * @return Database with an array of object stores.
     */
    @Returns("databaseWithObjectStores")
    DatabaseWithObjectStores requestDatabase(@Param("securityOrigin") String securityOrigin,
                                             @Param("databaseName") String databaseName);

    /**
     * Requests database names for given security origin.
     *
     * @param securityOrigin Security origin.
     * @return Database names for origin.
     */
    @Returns("databaseNames")
    List<String> requestDatabaseNames(@Param("securityOrigin") String securityOrigin);
}
