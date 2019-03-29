package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.debugger.SearchMatch;
import com.github.supermoonie.type.network.*;

import java.util.List;
import java.util.Map;

/**
 * Network domain allows tracking network activities of the page.
 * It exposes information about http, file, data
 * and other requests and responses, their headers,
 * bodies, timing, etc.
 *
 * @author supermoonie
 */
@Domain("Network")
public interface Network {

    /**
     * Tells whether clearing browser cache is supported.
     *
     * @return True if browser cache can be cleared.
     */
    @Deprecated
    @Returns("result")
    Boolean canClearBrowserCache();

    /**
     * Tells whether clearing browser cookies is supported.
     *
     * @return True if browser cookies can be cleared.
     */
    @Deprecated
    @Returns("result")
    Boolean canClearBrowserCookies();

    /**
     * Tells whether emulation of network conditions is supported.
     *
     * @return True if emulation of network conditions is supported.
     */
    @Deprecated
    @Returns("result")
    Boolean canEmulateNetworkConditions();

    /**
     * Clears browser cache.
     */
    void clearBrowserCache();

    /**
     * Clears browser cookies.
     */
    void clearBrowserCookies();

    /**
     * Deletes browser cookies with matching name and url or domain/path pair.
     *
     * @param name   Name of the cookies to remove.
     * @param url    If specified, deletes all the cookies with the given name where domain and path match provided URL.
     * @param domain If specified, deletes only cookies with the exact domain.
     * @param path   If specified, deletes only cookies with the exact path.
     */
    void deleteCookies(@Param("name") String name,
                       @Param("url") @Optional String url,
                       @Param("domain") @Optional String domain,
                       @Param("path") @Optional String path);

    /**
     * Disables network tracking, prevents network events from being sent to the client.
     */
    void disable();

    /**
     * Activates emulation of network conditions.
     *
     * @param offline            True to emulate internet disconnection.
     * @param latency            Minimum latency from request sent to response headers received (ms).
     * @param downloadThroughput Maximal aggregated download throughput (bytes/sec). -1 disables download throttling.
     * @param uploadThroughput   Maximal aggregated upload throughput (bytes/sec). -1 disables upload throttling.
     * @param connectionType     Connection type if known.
     */
    void emulateNetworkConditions(@Param("offline") boolean offline,
                                  @Param("latency") double latency,
                                  @Param("downloadThroughput") double downloadThroughput,
                                  @Param("uploadThroughput") double uploadThroughput,
                                  @Param("connectionType") @Optional ConnectionType connectionType);

    /**
     * Enables network tracking, network event will now be delivered to the client.
     *
     * @param maxTotalBufferSize    Buffer size in bytes to use when preserving network payloads (XHRs, etc).
     * @param maxResourceBufferSize Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc).
     * @param maxPostDataSize       Longest post body size (in bytes) that would be included in requestWillBeSent notification
     */
    void enable(@Param("maxTotalBufferSize") @Optional @Experimental Integer maxTotalBufferSize,
                @Param("maxResourceBufferSize") @Optional @Experimental Integer maxResourceBufferSize,
                @Param("maxPostDataSize") @Optional Integer maxPostDataSize);

    /**
     * Enables network tracking, network event will now be delivered to the client.
     */
    void enable();

    /**
     * Returns all browser cookies.
     * Depending on the backend support,
     * will return detailed cookie information in the cookies field.
     *
     * @return cookies
     */
    @Returns("cookies")
    List<Cookie> getAllCookies();

    /**
     * Returns all browser cookies for the current URL. Depending on the backend support, will return
     * detailed cookie information in the <code>cookies</code> field.
     *
     * @return Array of cookie objects.
     */
    @Returns("cookies")
    List<Cookie> getCookies();

    /**
     * Returns all browser cookies for the current URL. Depending on the backend support, will return
     * detailed cookie information in the <code>cookies</code> field.
     *
     * @param urls The list of URLs for which applicable cookies will be fetched
     * @return Array of cookie objects.
     */
    @Returns("cookies")
    List<Cookie> getCookies(@Param("urls") @Optional List<String> urls);

    /**
     * Returns content served for the given request.
     *
     * @param requestId Identifier of the network request to get content for.
     * @return GetResponseBodyResult
     */
    GetResponseBodyResult getResponseBody(@Param("requestId") String requestId);

    /**
     * Returns post data sent with the request. Returns an error when no data was sent with the request.
     *
     * @param requestId Identifier of the network request to get content for.
     * @return Base64-encoded request body.
     */
    @Returns("postData")
    String getRequestPostData(@Param("requestId") String requestId);

    /**
     * This method sends a new XMLHttpRequest which is identical to the original one.
     * The following parameters should be identical:
     * method, url, async, request body, extra headers, withCredentials attribute, user, password.
     *
     * @param requestId Identifier of XHR to replay.
     */
    @Experimental
    void replayXHR(@Param("requestId") String requestId);

    /**
     * Searches for given string in response content.
     *
     * @param requestId     Identifier of the network response to search.
     * @param query         String to search for.
     * @param caseSensitive If true, search is case sensitive.
     * @param isRegex       If true, treats string parameter as regex.
     * @return List of search matches.
     */
    @Experimental
    @Returns("result")
    List<SearchMatch> searchInResponseBody(@Param("requestId") String requestId,
                                           @Param("query") String query,
                                           @Param("caseSensitive") @Optional Boolean caseSensitive,
                                           @Param("isRegex") @Optional Boolean isRegex);

    /**
     * Blocks URLs from loading.
     *
     * @param urls URL patterns to block. Wildcards ('*') are allowed.
     */
    @Experimental
    void setBlockedURLs(@Param("urls") List<String> urls);

    /**
     * Toggles ignoring of service worker for each request.
     *
     * @param bypass Bypass service worker and load from network.
     */
    @Experimental
    void setBypassServiceWorker(@Param("bypass") boolean bypass);

    /**
     * Toggles ignoring cache for each request. If true, cache will not be used.
     *
     * @param cacheDisabled Cache disabled state.
     */
    void setCacheDisabled(@Param("cacheDisabled") boolean cacheDisabled);

    /**
     * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
     *
     * @param name     Cookie name.
     * @param value    Cookie value.
     * @param url      The request-URI to associate with the setting of the cookie. This value can affect the
     *                 default domain and path values of the created cookie.
     * @param domain   Cookie domain.
     * @param path     Cookie path.
     * @param secure   True if cookie is secure.
     * @param httpOnly True if cookie is http-only.
     * @param sameSite Cookie SameSite type.
     * @param expires  Cookie expiration date, session cookie if not set
     * @return True if successfully set cookie.
     */
    @Returns("success")
    Boolean setCookie(@Param("name") String name,
                      @Param("value") String value,
                      @Param("url") @Optional String url,
                      @Param("domain") @Optional String domain,
                      @Param("path") @Optional String path,
                      @Param("secure") @Optional Boolean secure,
                      @Param("httpOnly") @Optional Boolean httpOnly,
                      @Param("sameSite") @Optional CookieSameSite sameSite,
                      @Param("expires") @Optional Double expires);


    /**
     * Sets given cookies.
     *
     * @param cookies Cookies to be set.
     */
    void setCookies(@Param("cookies") List<CookieParam> cookies);

    /**
     * Specifies whether to always send extra HTTP headers with the requests from this page.
     *
     * @param headers Map with extra HTTP headers.
     */
    void setExtraHTTPHeaders(@Param("headers") Map<String, Object> headers);

    /**
     * Allows overriding user agent with the given string.
     *
     * @param userAgent      User agent to use.
     * @param acceptLanguage Browser language to emulate.
     * @param platform       The platform navigator.platform should return.
     */
    void setUserAgentOverride(@Param("userAgent") String userAgent,
                              @Param("acceptLanguage") @Optional String acceptLanguage,
                              @Param("platform") @Optional String platform);

    /**
     * Allows overriding user agent with the given string.
     *
     * @param userAgent User agent to use.
     */
    void setUserAgentOverride(@Param("userAgent") String userAgent);
}
