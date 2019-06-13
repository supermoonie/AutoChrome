package com.github.supermoonie.auto;

import com.github.supermoonie.type.network.Cookie;
import com.github.supermoonie.type.network.CookieParam;
import com.github.supermoonie.type.network.GetResponseBodyResult;
import org.slf4j.Logger;

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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        autoChrome.getNetwork().clearBrowserCache();
    }

    /**
     * clear browser cookies
     */
    default void clearBrowserCookies() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        autoChrome.getNetwork().clearBrowserCookies();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s)", name, url));
        autoChrome.getNetwork().deleteCookies(name, url, null, null);
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s， %s)", name, domain, path));
        autoChrome.getNetwork().deleteCookies(name, null, domain, path);
    }

    /**
     * get all cookies
     *
     * @return cookies
     */
    default List<Cookie> getAllCookies() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        return autoChrome.getNetwork().getAllCookies();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", Arrays.toString(urls)));
        return autoChrome.getNetwork().getCookies(Arrays.asList(urls));
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", requestId));
        return autoChrome.getNetwork().getResponseBody(requestId);
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", Arrays.toString(urls)));
        autoChrome.getNetwork().enable();
        autoChrome.getNetwork().setBlockedURLs(Arrays.asList(urls));
    }

    /**
     * set cache disable
     *
     * @param cacheDisabled cacheDisabled
     */
    default void setCacheDisabled(boolean cacheDisabled) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%b)", cacheDisabled));
        autoChrome.getNetwork().enable();
        autoChrome.getNetwork().setCacheDisabled(cacheDisabled);
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s, %s)", name, value, url));
        return autoChrome.getNetwork().setCookie(name, value, url, null, null, null, null, null, null);
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", cookies.toString()));
        autoChrome.getNetwork().setCookies(cookies);
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", headers.toString()));
        autoChrome.getNetwork().setExtraHTTPHeaders(headers);
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", userAgent));
        autoChrome.getNetwork().setUserAgentOverride(userAgent);
    }

    /**
     * set ignore certificate errors
     *
     * @param ignore ignore
     */
    default void setIgnoreCertificateErrors(boolean ignore) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%b)", ignore));
        autoChrome.getSecurity().setIgnoreCertificateErrors(ignore);
    }
}
