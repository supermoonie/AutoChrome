package com.github.supermoonie.command;

import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Experimental;
import com.github.supermoonie.annotation.Param;
import com.github.supermoonie.annotation.Returns;
import com.github.supermoonie.type.cachestorage.Cache;
import com.github.supermoonie.type.cachestorage.CachedResponse;
import com.github.supermoonie.type.cachestorage.RequestEntriesResult;

import java.util.List;

/**
 *
 * @author Administrator
 */
@Experimental
@Domain("CacheStorage")
public interface CacheStorage {
    /**
     * Deletes a cache.
     * 
     * @param cacheId Id of cache for deletion.
     */
    void deleteCache(@Param("cacheId") String cacheId);

    /**
     * Deletes a cache entry.
     * 
     * @param cacheId Id of cache where the entry will be deleted.
     * @param request URL spec of the request.
     */
    void deleteEntry(@Param("cacheId") String cacheId, @Param("request") String request);

    /**
     * Requests cache names.
     * when event {@link com.github.supermoonie.event.storage.CacheStorageListUpdated} occurred
     * this method can be called
     * 
     * @param securityOrigin Security origin.
     * 
     * @return Caches for the security origin.
     */
    @Returns("caches")
    List<Cache> requestCacheNames(@Param("securityOrigin") String securityOrigin);

    /**
     * Fetches cache entry.
     * 
     * @param cacheId Id of cache that contains the enty.
     * @param requestURL URL spec of the request.
     * 
     * @return Response read from the cache.
     */
    @Returns("response")
    CachedResponse requestCachedResponse(@Param("cacheId") String cacheId, @Param("requestURL") String requestURL);

    /**
     * Requests data from cache.
     * 
     * @param cacheId ID of cache to get entries from.
     * @param skipCount Number of records to skip.
     * @param pageSize Number of records to fetch.
     * 
     * @return RequestEntriesResult
     */
    RequestEntriesResult requestEntries(@Param("cacheId") String cacheId, @Param("skipCount") Integer skipCount, @Param("pageSize") Integer pageSize);
}
