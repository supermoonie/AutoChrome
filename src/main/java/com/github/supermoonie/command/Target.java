package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.target.RemoteLocation;
import com.github.supermoonie.type.target.TargetInfo;

import java.util.List;

/**
 * @author supermoonie
 */
@Domain("Target")
public interface Target {

    /**
     * Activates (focuses) the target.
     *
     * @param targetId target id
     */
    void activateTarget(@Param("targetId") String targetId);

    /**
     * Attaches to the target with given id.
     *
     * @param targetId target id
     * @param flatten  Enables "flat" access to the session via specifying sessionId attribute in the commands.
     */
    void attachToTarget(@Param("targetId") String targetId,
                        @Param("flatten") @Optional @Experimental Boolean flatten);

    /**
     * Attaches to the browser target, only uses flat sessionId mode.
     *
     * @return Id assigned to the session.
     */
    @Experimental
    @Returns("sessionId")
    String attachToBrowserTarget();

    /**
     * Closes the target. If the target is a page that gets closed too.
     *
     * @param targetId target id
     * @return True is closed.
     */
    @Returns("success")
    Boolean closeTarget(@Param("targetId") String targetId);

    /**
     * Inject object to the target's main frame that provides a communication channel with browser target.
     * Injected object will be available as window[bindingName].
     * The object has the follwing API:
     * binding.send(json) - a method to send messages over the remote debugging protocol
     * binding.onmessage = json => handleMessage(json) - a callback that will be called for the protocol notifications and command responses.
     *
     * @param targetId    target id
     * @param bindingName Binding name, 'cdp' if not specified.
     */
    @Experimental
    void exposeDevToolsProtocol(@Param("targetId") String targetId,
                                @Param("bindingName") @Optional String bindingName);

    /**
     * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than one.
     *
     * @return The id of the context created.
     */
    @Experimental
    @Returns("browserContextId")
    String createBrowserContext();

    /**
     * Returns all browser contexts created with Target.createBrowserContext method.
     *
     * @return An array of browser context ids.
     */
    @Experimental
    @Returns("browserContextIds")
    List<String> getBrowserContexts();

    /**
     * Creates a new page.
     *
     * @param url                     The initial URL the page will be navigated to.
     * @param width                   Frame width in DIP (headless chrome only).
     * @param height                  Frame height in DIP (headless chrome only).
     * @param browserContextId        The browser context to create the page in.
     * @param enableBeginFrameControl Whether BeginFrames for this target will be controlled via DevTools (headless chrome only,
     *                                not supported on MacOS yet, false by default).
     * @return The id of the page opened.
     */
    @Returns("targetId")
    String createTarget(@Param("url") String url,
                        @Param("width") @Optional Integer width,
                        @Param("height") @Optional Integer height,
                        @Param("browserContextId") @Optional String browserContextId,
                        @Param("enableBeginFrameControl") @Optional @Experimental Boolean enableBeginFrameControl);

    /**
     * Detaches session with given id.
     *
     * @param sessionId Session to detach.
     */
    void detachFromTarget(@Param("sessionId") @Optional String sessionId);

    /**
     * Deletes a BrowserContext.
     * All the belonging pages will be closed without calling their beforeunload hooks.
     *
     * @param browserContextId browser context id
     */
    @Experimental
    void disposeBrowserContext(@Param("browserContextId") String browserContextId);

    /**
     * Returns information about a target.
     *
     * @param targetId target id
     * @return target info.
     */
    @Experimental
    @Returns("targetInfo")
    TargetInfo getTargetInfo(@Param("targetId") @Optional String targetId);

    /**
     * Retrieves a list of available targets.
     *
     * @return The list of targets.
     */
    @Returns("targetInfos")
    List<TargetInfo> getTargets();

    /**
     * Controls whether to discover available targets and notify via
     * <code>targetCreated/targetInfoChanged/targetDestroyed</code> event.
     *
     * @param discover Whether to discover available targets.
     */
    void setDiscoverTargets(@Param("discover") Boolean discover);

    /**
     * Sends protocol message over session with given id.
     *
     * @param message   message
     * @param sessionId Identifier of the session.
     * @param targetId  Deprecated.
     */
    void sendMessageToTarget(@Param("message") String message,
                             @Param("sessionId") @Optional String sessionId,
                             @Param("targetId") @Optional String targetId);

    /**
     * Controls whether to automatically attach to new targets which are considered to be related to this one.
     * When turned on, attaches to all existing related targets as well.
     * When turned off, automatically detaches from all currently attached targets.
     *
     * @param autoAttach             Whether to auto-attach to related targets.
     * @param waitForDebuggerOnStart Whether to pause new targets when attaching to them.
     *                               Use Runtime.runIfWaitingForDebugger to run paused targets.
     * @param flatten                Enables "flat" access to the session via specifying sessionId attribute in the commands.
     */
    void setAutoAttach(@Param("autoAttach") boolean autoAttach,
                       @Param("waitForDebuggerOnStart") boolean waitForDebuggerOnStart,
                       @Param("flatten") @Optional @Experimental Boolean flatten);

    /**
     * Controls whether to discover available targets
     * and notify via targetCreated/targetInfoChanged/targetDestroyed events.
     *
     * @param discover Whether to discover available targets.
     */
    void setDiscoverTargets(@Param("discover") boolean discover);

    /**
     * Enables target discovery for the specified locations, when setDiscoverTargets was set to true.
     *
     * @param locations List of remote locations.
     */
    @Experimental
    void setRemoteLocations(@Param("locations") List<RemoteLocation> locations);

}
