package com.github.supermoonie.type.storage;


/**
 * Enum of possible storage types.
 * 
 * @author supermoonie
 */
public enum StorageType {

    /**
     * appcache
     */
    appcache("appcache"),
    /**
     * cookies
     */
    cookies("cookies"),
    /**
     * file_systems
     */
    file_systems("file_systems"),
    /**
     * indexeddb
     */
    indexeddb("indexeddb"),
    /**
     * local_storage
     */
    local_storage("local_storage"),
    /**
     * shader_cache
     */
    shader_cache("shader_cache"),
    /**
     * websql
     */
    websql("websql"),
    /**
     * service_workers
     */
    service_workers("service_workers"),
    /**
     * cache_storage
     */
    cache_storage("cache_storage"),
    /**
     * all
     */
    all("all"),
    /**
     * other
     */
    other("other"),
    ;

    public final String value;

    StorageType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}