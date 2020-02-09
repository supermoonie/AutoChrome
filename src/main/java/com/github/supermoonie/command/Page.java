package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.debugger.SearchMatch;
import com.github.supermoonie.type.page.*;

/**
 * @author Administrator
 * @since 2018/8/28 0028
 */
@Domain("Page")
public interface Page {

    /**
     * Evaluates given script in every frame upon creation (before loading frame's scripts).
     *
     * @param source    source
     * @param worldName If specified, creates an isolated world with the given name and evaluates given script in it.
     *                  This world name will be used as the ExecutionContextDescription::name
     *                  when the corresponding event is emitted.
     * @return Identifier of the added script.
     */
    @Returns("identifier")
    String addScriptToEvaluateOnNewDocument(@Param("source") String source,
                                            @Param("worldName") @Optional @Experimental String worldName);

    /**
     * Brings page to front (activates tab).
     */
    void bringToFront();

    /**
     * Capture page screenshot.
     *
     * @param format      Image compression format (defaults to png).jpeg, png
     * @param quality     Compression quality from range [0..100] (jpeg only).
     * @param clip        Capture the screenshot of a given region only.
     * @param fromSurface Capture the screenshot from the surface, rather than the view. Defaults to true.
     * @return Base64-encoded image data.
     */
    @Returns("data")
    String captureScreenshot(@Param("format") @Optional String format,
                             @Param("quality") @Optional Integer quality,
                             @Param("clip") @Optional Viewport clip,
                             @Param("fromSurface") @Optional Boolean fromSurface);

    /**
     * Capture page screenshot.
     *
     * @return Base64-encoded image data.
     */
    @Returns("data")
    String captureScreenshot();

    /**
     * Returns a snapshot of the page as a string.
     * For MHTML format, the serialization includes iframes, shadow DOM, external resources, and element-inline styles.
     *
     * @param format Format (defaults to mhtml).mhtml
     * @return Serialized page data.
     */
    @Returns("data")
    String captureSnapshot(@Param("format") @Optional String format);

    /**
     * Creates an isolated world for the given frame.
     *
     * @param frameId             Id of the frame in which the isolated world should be created.
     * @param worldName           An optional name which is reported in the Execution Context.
     * @param grantUniveralAccess Whether or not universal access should be granted to the isolated world.
     *                            This is a powerful option, use with caution.
     * @return Creates an isolated world for the given frame.
     */
    @Returns("executionContextId")
    Integer createIsolatedWorld(@Param("frameId") String frameId,
                                @Param("worldName") @Optional String worldName,
                                @Param("grantUniveralAccess") @Optional Boolean grantUniveralAccess);

    /**
     * Disables page domain notifications.
     */
    void disable();

    /**
     * Enables page domain notifications.
     */
    void enable();

    /**
     * get app manifest
     *
     * @return GetAppManifestResult
     */
    GetAppManifestResult getAppManifest();

    /**
     * Returns present frame tree structure.
     *
     * @return FrameTree
     */
    @Returns("frameTree")
    FrameTree getFrameTree();

    /**
     * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
     *
     * @return GetLayoutMetricsResult
     */
    GetLayoutMetricsResult getLayoutMetrics();

    /**
     * Returns navigation history for the current page.
     *
     * @return GetNavigationHistoryResult
     */
    GetNavigationHistoryResult getNavigationHistory();

    /**
     * Returns content of the given resource.
     *
     * @param frameId Frame id to get resource for.
     * @param url     URL of the resource to get content for.
     * @return GetResourceContentResult
     */
    @Experimental
    GetResourceContentResult getResourceContent(@Param("frameId") String frameId,
                                                @Param("url") String url);

    /**
     * Returns present frame / resource tree structure.
     *
     * @return FrameResourceTree
     */
    @Experimental
    @Returns("frameTree")
    FrameResourceTree getResourceTree();

    /**
     * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
     *
     * @param accept     Whether to accept or dismiss the dialog.
     * @param promptText The text to enter into the dialog prompt before accepting.
     *                   Used only if this is a prompt dialog.
     */
    void handleJavaScriptDialog(@Param("accept") boolean accept,
                                @Param("promptText") @Optional String promptText);

    /**
     * Navigates current page to the given URL.
     *
     * @param url            URL to navigate the page to.
     * @param referrer       Referrer URL.
     * @param transitionType Intended transition type.
     * @param frameId        Frame id to navigate, if not specified navigates the top frame.
     * @return NavigateResult
     */
    NavigateResult navigate(@Param("url") String url,
                            @Param("referrer") @Optional String referrer,
                            @Param("transitionType") @Optional TransitionType transitionType,
                            @Param("frameId") @Optional String frameId);

    /**
     * Navigates current page to the given URL.
     *
     * @param url URL to navigate the page to.
     * @return NavigateResult
     */
    NavigateResult navigate(@Param("url") String url);

    /**
     * Navigates current page to the given history entry.
     *
     * @param entryId Unique id of the entry to navigate to.
     */
    void navigateToHistoryEntry(@Param("entryId") int entryId);

    /**
     * Print page as PDF.
     *
     * @param landscape               Paper orientation. Defaults to false.
     * @param displayHeaderFooter     Display header and footer. Defaults to false.
     * @param printBackground         Print background graphics. Defaults to false.
     * @param scale                   Scale of the webpage rendering. Defaults to 1.
     * @param paperWidth              Paper width in inches. Defaults to 8.5 inches.
     * @param paperHeight             Paper height in inches. Defaults to 11 inches.
     * @param marginTop               Top margin in inches. Defaults to 1cm (~0.4 inches).
     * @param marginBottom            Bottom margin in inches. Defaults to 1cm (~0.4 inches).
     * @param marginLeft              Left margin in inches. Defaults to 1cm (~0.4 inches).
     * @param marginRight             Right margin in inches. Defaults to 1cm (~0.4 inches).
     * @param pageRanges              Paper ranges to print, e.g., '1-5, 8, 11-13'. Defaults to the empty string, which means print all pages.
     * @param ignoreInvalidPageRanges Whether to silently ignore invalid but successfully parsed page ranges, such as '3-2'. Defaults to false.
     * @param headerTemplate          HTML template for the print header.
     *                                Should be valid HTML markup with following classes used to inject printing values into them:
     *                                date: formatted print date
     *                                title: document title
     *                                url: document location
     *                                pageNumber: current page number
     *                                totalPages: total pages in the document
     *                                For example, <span class=title></span> would generate span containing the title.
     * @param footerTemplate          HTML template for the print footer. Should use the same format as the headerTemplate.
     * @param preferCSSPageSize       Whether or not to prefer page size as defined by css. Defaults to false,
     *                                in which case the content will be scaled to fit the paper size.
     * @return Base64-encoded pdf data.
     */
    @Returns("data")
    String printToPDF(@Param("landscape") @Optional Boolean landscape,
                      @Param("displayHeaderFooter") @Optional Boolean displayHeaderFooter,
                      @Param("printBackground") @Optional Boolean printBackground,
                      @Param("scale") @Optional Double scale,
                      @Param("paperWidth") @Optional Double paperWidth,
                      @Param("paperHeight") @Optional Double paperHeight,
                      @Param("marginTop") @Optional Double marginTop,
                      @Param("marginBottom") @Optional Double marginBottom,
                      @Param("marginLeft") @Optional Double marginLeft,
                      @Param("marginRight") @Optional Double marginRight,
                      @Param("pageRanges") @Optional String pageRanges,
                      @Param("ignoreInvalidPageRanges") @Optional Boolean ignoreInvalidPageRanges,
                      @Param("headerTemplate") @Optional String headerTemplate,
                      @Param("footerTemplate") @Optional String footerTemplate,
                      @Param("preferCSSPageSize") @Optional Boolean preferCSSPageSize);

    /**
     * Print page as PDF.
     *
     * @return Base64-encoded pdf data.
     */
    @Returns("data")
    String printToPDF();

    /**
     * Reloads given page optionally ignoring the cache.
     *
     * @param ignoreCache            If true, browser cache is ignored (as if the user pressed Shift+refresh).
     * @param scriptToEvaluateOnLoad If set, the script will be injected into all frames of the inspected page after reload.
     *                               Argument will be ignored if reloading dataURL origin.
     */
    void reload(@Param("ignoreCache") @Optional Boolean ignoreCache,
                @Param("scriptToEvaluateOnLoad") @Optional String scriptToEvaluateOnLoad);

    /**
     * Removes given script from the list.
     *
     * @param identifier Unique script identifier.
     */
    void removeScriptToEvaluateOnNewDocument(@Param("identifier") String identifier);

    /**
     * Acknowledges that a screencast frame has been received by the frontend.
     *
     * @param sessionId Frame number.
     */
    @Experimental
    void screencastFrameAck(@Param("sessionId") int sessionId);

    /**
     * Searches for given string in resource content.
     *
     * @param frameId       Frame id for resource to search in.
     * @param url           URL of the resource to search in.
     * @param query         String to search for.
     * @param caseSensitive If true, search is case sensitive.
     * @param isRegex       If true, treats string parameter as regex.
     * @return List of search matches.
     */
    @Experimental
    @Returns("result")
    SearchMatch searchInResource(@Param("frameId") String frameId,
                                 @Param("url") String url,
                                 @Param("query") String query,
                                 @Param("caseSensitive") @Optional Boolean caseSensitive,
                                 @Param("isRegex") @Optional Boolean isRegex);

    /**
     * Enable Chrome's experimental ad filter on all sites.
     *
     * @param enabled Whether to block ads.
     */
    @Experimental
    void setAdBlockingEnabled(@Param("enabled") boolean enabled);

    /**
     * Enable page Content Security Policy by-passing.
     *
     * @param enabled Whether to bypass page CSP.
     */
    @Experimental
    void setBypassCSP(@Param("enabled") boolean enabled);

    /**
     * Set generic font families.
     *
     * @param fontFamilies Specifies font families to set. If a font family is not specified, it won't be changed.
     */
    void setFontFamilies(@Param("fontFamilies") FontFamilies fontFamilies);

    /**
     * Set default font sizes.
     *
     * @param fontSizes Specifies font sizes to set. If a font size is not specified, it won't be changed.
     */
    @Experimental
    void setFontSizes(@Param("fontSizes") FontSizes fontSizes);

    /**
     * Sets given markup as the document's HTML.
     *
     * @param frameId Frame id to set HTML for.
     * @param html    HTML content to set.
     */
    void setDocumentContent(@Param("frameId") String frameId, @Param("html") String html);

    /**
     * Set the behavior when downloading a file.
     *
     * @param behavior     Whether to allow all or deny all download requests,
     *                     or use default Chrome behavior if available (otherwise deny).deny, allow, default
     * @param downloadPath The default path to save downloaded files to. This is requred if behavior is set to 'allow'
     */
    @Experimental
    void setDownloadBehavior(@Param("behavior") String behavior, @Param("downloadPath") @Optional String downloadPath);

    /**
     * Controls whether page will emit lifecycle event.
     *
     * @param enabled If true, starts emitting lifecycle event.
     */
    @Experimental
    void setLifecycleEventsEnabled(@Param("enabled") Boolean enabled);

    /**
     * Starts sending each frame using the screencastFrame event.
     *
     * @param format        Image compression format.jpeg, png
     * @param quality       Compression quality from range [0..100].
     * @param maxWidth      Maximum screenshot width.
     * @param maxHeight     Maximum screenshot height.
     * @param everyNthFrame Send every n-th frame.
     */
    @Experimental
    void startScreencast(@Param("format") @Optional String format,
                         @Param("quality") @Optional Integer quality,
                         @Param("maxWidth") @Optional Integer maxWidth,
                         @Param("maxHeight") @Optional Integer maxHeight,
                         @Param("everyNthFrame") @Optional Integer everyNthFrame);

    /**
     * Force the page stop all navigations and pending resource fetches.
     */
    void stopLoading();

    /**
     * Crashes renderer on the IO thread, generates minidumps.
     */
    @Experimental
    void crash();

    /**
     * Tries to close page, running its beforeunload hooks, if any.
     */
    @Experimental
    void close();

    /**
     * Tries to update the web lifecycle state of the page.
     * It will transition the page to the given state according to: https://github.com/WICG/web-lifecycle/
     *
     * @param state Target lifecycle statefrozen, active
     */
    @Experimental
    void setWebLifecycleState(@Param("state") String state);

    /**
     * Stops sending each frame in the screencastFrame.
     */
    @Experimental
    void stopScreencast();

    /**
     * Forces compilation cache to be generated for every subresource script.
     *
     * @param enabled is enable
     */
    @Experimental
    void setProduceCompilationCache(@Param("enabled") boolean enabled);

    /**
     * Seeds compilation cache for given url. Compilation cache does not survive cross-process navigation.
     *
     * @param url  url
     * @param data Base64-encoded data
     */
    @Experimental
    void addCompilationCache(@Param("url") String url, @Param("data") String data);

    /**
     * Clears seeded compilation cache.
     */
    @Experimental
    void clearCompilationCache();

    /**
     * Generates a report for testing.
     *
     * @param message Message to be displayed in the report.
     * @param group   Specifies the endpoint group to deliver the report to.
     */
    void generateTestReport(@Param("message") String message, @Param("group") @Optional String group);
}
