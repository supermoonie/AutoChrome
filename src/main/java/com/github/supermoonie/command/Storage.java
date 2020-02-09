package com.github.supermoonie.command;

import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Experimental;
import com.github.supermoonie.annotation.Param;
import com.github.supermoonie.type.storage.GetUsageAndQuotaResult;

/**
 * @author wangchao
 * @since 2018/11/14 21:20
 */
@Experimental
@Domain("Storage")
public interface Storage {

    /**
     * Clears storage for origin.
     *
     * @param origin       Security origin.
     * @param storageTypes Comma separated origin names.
     */
    void clearDataForOrigin(@Param("origin") String origin,
                            @Param("storageTypes") String storageTypes);

    /**
     * Returns usage and quota in bytes.
     *
     * @param origin Security origin.
     * @return GetUsageAndQuotaResult
     */
    GetUsageAndQuotaResult getUsageAndQuota(@Param("origin") String origin);

    /**
     * Registers origin to be notified when an update occurs to its cache storage list.
     *
     * @param origin Security origin.
     */
    void trackCacheStorageForOrigin(@Param("origin") String origin);

    /**
     * Registers origin to be notified when an update occurs to its IndexedDB.
     *
     * @param origin Security origin.
     */
    void trackIndexedDBForOrigin(@Param("origin") String origin);

    /**
     * Unregisters origin from receiving notifications for cache storage.
     *
     * @param origin Security origin.
     */
    void untrackCacheStorageForOrigin(@Param("origin") String origin);

    /**
     * Unregisters origin from receiving notifications for IndexedDB.
     *
     * @param origin Security origin.
     */
    void untrackIndexedDBForOrigin(@Param("origin") String origin);
}
