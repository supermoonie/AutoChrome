package com.github.supermoonie.auto;

import com.github.supermoonie.command.Emulation;
import com.github.supermoonie.command.Page;
import com.github.supermoonie.exception.AutoChromeException;
import com.github.supermoonie.exception.NavigateFailedException;
import com.github.supermoonie.exception.NoDialogException;
import com.github.supermoonie.type.dom.Rect;
import com.github.supermoonie.type.page.*;
import com.github.supermoonie.type.target.TargetInfo;
import org.slf4j.Logger;

import java.util.Base64;
import java.util.List;
import java.util.Stack;

import static com.github.supermoonie.util.StringUtils.isEmpty;

/**
 * @author supermoonie
 * @date 2018/11/27
 */
public interface AutoPage extends Auto {

    /**
     * add script to evaluate on new document
     *
     * @param javaScript javaScript
     */
    default void addScriptToEvaluateOnNewDocument(String javaScript) {
        if (isEmpty(javaScript)) {
            return;
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", javaScript));
        autoChrome.getPage().addScriptToEvaluateOnNewDocument(javaScript, null);
    }

    /**
     * capture screenshot by selector
     *
     * @param selector selector
     * @return Base64-encoded image.
     */
    default String captureScreenshot(String selector) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty!");
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", selector));
        List<List<Double>> quads = autoChrome.getContentQuads(selector);
        List<Double> quad = quads.get(0);
        Double x = quad.get(0);
        Double y = quad.get(1);
        Double width = quad.get(2) - x;
        Double height = quad.get(7) - y;
        Viewport viewport = new Viewport();
        viewport.setX(x);
        viewport.setY(y);
        viewport.setHeight(height);
        viewport.setWidth(width);
        viewport.setScale(1.0);
        return this.captureScreenshot(viewport);
    }

    /**
     * capture screenshot
     *
     * @param viewport viewport
     * @return Base64-encoded image.
     */
    default String captureScreenshot(Viewport viewport) {
        if (null == viewport) {
            return null;
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", viewport.toString()));
        return autoChrome.getPage().captureScreenshot("png", 20, viewport, null);
    }

    /**
     * capture screenshot
     *
     * @return Base64-encoded image.
     */
    default String captureScreenshot() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        return autoChrome.getPage().captureScreenshot();
    }

    /**
     * capture full screenshot
     *
     * @return Base64-encoded image.
     */
    default String captureFullScreenshot() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        Page page = autoChrome.getPage();
        GetLayoutMetricsResult layoutMetrics = page.getLayoutMetrics();
        Rect contentSize = layoutMetrics.getContentSize();
        Emulation emulation = autoChrome.getEmulation();
        emulation.setDeviceMetricsOverride(contentSize.getWidth().intValue(), contentSize.getHeight().intValue(), 1D, false, null, null, null, null, null, null, null, null);
        String base64Image = page.captureScreenshot();
        emulation.clearDeviceMetricsOverride();
        emulation.resetPageScaleFactor();
        return base64Image;
    }

    /**
     * capture snapshot
     *
     * @return .mhtml
     */
    default String captureSnapshot() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        return autoChrome.getPage().captureSnapshot(null);
    }

    /**
     * get content
     *
     * @return content
     */
    default String getContent() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        return (String) autoChrome.eval("document.body.outerHTML");
    }

    /**
     * get content
     *
     * @param url url
     * @return content
     */
    default String getContent(String url) {
        if (isEmpty(url)) {
            return null;
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", url));
        String frameId = getFrameId(url);
        if (null == frameId) {
            return null;
        }
        GetResourceContentResult resourceContent = autoChrome.getPage().getResourceContent(frameId, url);
        if (resourceContent.getBase64Encoded()) {
            return new String(Base64.getDecoder().decode(resourceContent.getContent()));
        } else {
            return resourceContent.getContent();
        }
    }

    /**
     * handle javaScript dialog
     *
     * @param accept     accept
     * @param promptText prompt text
     */
    default void handleJavaScriptDialog(boolean accept, String promptText) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%b, %s)", accept, promptText));
        for (int i = 0; ; i++) {
            if (i >= 20) {
                throw new NoDialogException();
            }
            try {
                Thread.sleep(150L);
            } catch (InterruptedException e) {
                throw new AutoChromeException(e);
            }
            if (null == autoChrome.getJavascriptDialogOpening()) {
                continue;
            }
            autoChrome.getPage().handleJavaScriptDialog(accept, promptText);
            return;
        }
    }

    /**
     * navigate
     *
     * @param url url
     * @return NavigateResult
     */
    default NavigateResult navigate(String url) {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("url is empty!");
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", url));
        NavigateResult navigateResult = autoChrome.getPage().navigate(url);
        if (null == navigateResult) {
            throw new NavigateFailedException("could not load " + url);
        }
        if (null != navigateResult.getErrorText()) {
            throw new NavigateFailedException(navigateResult.getErrorText());
        }
        return navigateResult;
    }

    /**
     * navigate
     *
     * @param url            url
     * @param referrer       referrer
     * @param transitionType Intended transition type.
     * @param frameId        Frame id to navigate, if not specified navigates the top frame.
     * @return NavigateResult
     */
    default NavigateResult navigate(String url, String referrer, TransitionType transitionType, String frameId) {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("url is empty!");
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s, %s, %s)", url, referrer, transitionType.toString(), frameId));
        NavigateResult navigateResult = autoChrome.getPage().navigate(url, referrer, transitionType, frameId);
        if (null == navigateResult) {
            throw new NavigateFailedException("could not load " + url);
        }
        if (null != navigateResult.getErrorText()) {
            throw new NavigateFailedException(navigateResult.getErrorText());
        }
        return navigateResult;
    }

    /**
     * back
     */
    default void back() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        Page page = autoChrome.getPage();
        GetNavigationHistoryResult history = page.getNavigationHistory();
        int index = history.getCurrentIndex() - 1;
        if (index < 0 || index >= history.getEntries().size()) {
            return;
        }
        NavigationEntry entry = history.getEntries().get(index);
        if (entry != null) {
            page.navigateToHistoryEntry(entry.getId());
        }
    }

    /**
     * forward
     */
    default void forward() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        Page page = autoChrome.getPage();
        GetNavigationHistoryResult history = page.getNavigationHistory();
        int index = history.getCurrentIndex() + 1;
        if (index >= history.getEntries().size()) {
            return;
        }
        NavigationEntry entry = history.getEntries().get(index);
        if (entry != null) {
            page.navigateToHistoryEntry(entry.getId());
        }
    }

    /**
     * reload
     *
     * @param ignoreCache            ignore cache
     * @param scriptToEvaluateOnLoad script to evaluate on load
     */
    default void reload(Boolean ignoreCache, String scriptToEvaluateOnLoad) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%b, %s)", ignoreCache, scriptToEvaluateOnLoad));
        autoChrome.getPage().reload(ignoreCache, scriptToEvaluateOnLoad);
    }

    /**
     * stop loading
     */
    default void stopLoading() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        getThis().getPage().stopLoading();
    }

    /**
     * set content
     *
     * @param html content
     */
    default void setContent(String html) {
        if (null == html) {
            return;
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", html));
        TargetInfo targetInfo = autoChrome.getTarget().getTargetInfo(autoChrome.getTableId());
        String currentUrl = targetInfo.getUrl();
        String frameId = getFrameId(currentUrl);
        autoChrome.getPage().setDocumentContent(frameId, html);
    }

    /**
     * set download behavior
     *
     * @param type         type
     * @param downloadPath path
     */
    default void setDownloadBehavior(DownLoadBehaviorType type, String downloadPath) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s)", type.toString(), downloadPath));
        autoChrome.getPage().setDownloadBehavior(type.toString(), downloadPath);
    }

    /**
     * get frame id
     *
     * @param url url
     * @return frame id
     */
    default String getFrameId(String url) {
        if (isEmpty(url)) {
            return null;
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", url));
        FrameResourceTree resourceTree = autoChrome.getPage().getResourceTree();
        String frameId = null;
        Stack<FrameResourceTree> stack = new Stack<>();
        stack.push(resourceTree);
        while (!stack.empty()) {
            FrameResourceTree tree = stack.pop();
            if (url.equals(tree.getFrame().getUrl())) {
                frameId = tree.getFrame().getId();
                break;
            }
            if (null != tree.getChildFrames() && tree.getChildFrames().size() > 0) {
                List<FrameResourceTree> childFrames = tree.getChildFrames();
                for (FrameResourceTree childTree : childFrames) {
                    stack.push(childTree);
                }
            }
        }
        return frameId;
    }
}
