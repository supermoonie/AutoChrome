package com.github.supermoonie.auto;

import com.github.supermoonie.type.network.Cookie;
import com.github.supermoonie.type.network.CookieParam;
import com.github.supermoonie.type.network.GetResponseBodyResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.github.supermoonie.util.StringUtils.*;

/**
 * @author supermoonie
 * @date 2018/11/22
 */
public interface AutoNetwork extends Auto {

    /**
     * clear browser cache
     */
    default void clearBrowserCache() {
        getThis().getNetwork().clearBrowserCache();
    }

    /**
     * clear browser cookies
     */
    default void clearBrowserCookies() {
        getThis().getNetwork().clearBrowserCookies();
    }

    /**
     * delete cookies
     *
     * @param name name
     * @param url  url
     */
    default void deleteCookies(String name, String url) {
        if (isAnyEmpty(name, url)) {
            return;
        }
        getThis().getNetwork().deleteCookies(name, url, null, null);
    }

    /**
     * delete cookies
     *
     * @param name   name
     * @param domain domain
     * @param path   path
     */
    default void deleteCookies(String name, String domain, String path) {
        if (isAnyEmpty(name, domain, path)) {
            return;
        }
        getThis().getNetwork().deleteCookies(name, null, domain, path);
    }

    /**
     * get all cookies
     *
     * @return cookies
     */
    default List<Cookie> getAllCookies() {
        return getThis().getNetwork().getAllCookies();
    }

    /**
     * get cookies
     *
     * @param urls urls
     * @return cookies
     */
    default List<Cookie> getCookies(String... urls) {
        if (null == urls || urls.length == 0) {
            return new ArrayList<>();
        }
        if (isAnyEmpty(urls)) {
            return new ArrayList<>();
        }
        return getThis().getNetwork().getCookies(Arrays.asList(urls));
    }

    /**
     * get response body
     *
     * @param requestId request id
     * @return GetResponseBodyResult
     */
    default GetResponseBodyResult getResponseBody(String requestId) {
        if (isEmpty(requestId)) {
            throw new IllegalArgumentException("request id is empty!");
        }
        return getThis().getNetwork().getResponseBody(requestId);
    }

    /**
     * set blocked urls
     *
     * @param urls urls
     */
    default void setBlockedURLs(String... urls) {
        if (isAllEmpty(urls)) {
            return;
        }
        getThis().getNetwork().enable();
        getThis().getNetwork().setBlockedURLs(Arrays.asList(urls));
    }

    /**
     * set cache disable
     *
     * @param cacheDisabled cacheDisabled
     */
    default void setCacheDisabled(boolean cacheDisabled) {
        getThis().getNetwork().enable();
        getThis().getNetwork().setCacheDisabled(cacheDisabled);
    }

    /**
     * set cookie
     *
     * @param name  name
     * @param value value
     * @param url   url
     * @return True if successfully set cookie.
     */
    default boolean setCookie(String name, String value, String url) {
        if (isAnyEmpty(name, value, url)) {
            return false;
        }
        return getThis().getNetwork().setCookie(name, value, url, null, null, null, null, null, null);
    }

    /**
     * set cookies
     *
     * @param cookies cookies
     */
    default void setCookies(List<CookieParam> cookies) {
        if (null == cookies || cookies.size() == 0) {
            return;
        }
        getThis().getNetwork().setCookies(cookies);
    }

    /**
     * set extra headers
     *
     * @param headers headers
     */
    default void setExtraHTTPHeaders(Map<String, Object> headers) {
        if (null == headers || headers.size() == 0) {
            return;
        }
        getThis().getNetwork().setExtraHTTPHeaders(headers);
    }

    /**
     * set User-Agent override
     *
     * @param userAgent User-Agent
     */
    default void setUserAgentOverride(String userAgent) {
        if (isEmpty(userAgent)) {
            throw new IllegalArgumentException("userAgent is empty!");
        }
        getThis().getNetwork().setUserAgentOverride(userAgent);
    }

    /**
     * set ignore certificate errors
     *
     * @param ignore ignore
     */
    default void setIgnoreCertificateErrors(boolean ignore) {
        getThis().getSecurity().setIgnoreCertificateErrors(ignore);
    }
}
