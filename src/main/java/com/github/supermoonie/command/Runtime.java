package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.runtime.*;

import java.util.List;

/**
 * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects.
 * Evaluation results are returned as mirror object that expose object type,
 * string representation and unique identifier that can be used for further object reference.
 * Original objects are maintained in memory unless they are either explicitly released
 * or are released along with the other objects in their object group.
 *
 * @author Administrator
 * @since 2018/8/28 0028
 */
@Domain("Runtime")
public interface Runtime {

    /**
     * Add handler to promise with given promise object id.
     *
     * @param promiseObjectId Identifier of the promise.
     * @param returnByValue   Whether the result is expected to be a JSON object that should be sent by value.
     * @param generatePreview Whether preview should be generated for the result.
     * @return AwaitPromiseResult
     */
    AwaitPromiseResult awaitPromise(@Param("promiseObjectId") String promiseObjectId,
                                    @Param("returnByValue") @Optional Boolean returnByValue,
                                    @Param("generatePreview") @Optional Boolean generatePreview);

    /**
     * Calls function with given declaration on the given object.
     * Object group of the result is inherited from the target object.
     *
     * @param functionDeclaration Declaration of the function to call.
     * @param objectId            Identifier of the object to call function on.
     *                            Either objectId or executionContextId should be specified.
     * @param arguments           Call arguments. All call arguments must belong to the same JavaScript world as the target object.
     * @param silent              In silent mode exceptions thrown during evaluation are not reported and do not pause execution.
     *                            Overrides setPauseOnException state.
     * @param returnByValue       Whether the result is expected to be a JSON object which should be sent by value.
     * @param generatePreview     Whether preview should be generated for the result.
     * @param userGesture         Whether execution should be treated as initiated by user in the UI.
     * @param awaitPromise        Whether execution should await for resulting value and return once awaited promise is resolved.
     * @param executionContextId  Specifies execution context which global object will be used to call function on.
     *                            Either executionContextId or objectId should be specified.
     * @param objectGroup         Symbolic group name that can be used to release multiple objects.
     *                            If objectGroup is not specified and objectId is, objectGroup will be inherited from object.
     * @return CallFunctionOnResult
     */
    CallFunctionOnResult callFunctionOn(@Param("functionDeclaration") String functionDeclaration,
                                        @Param("objectId") @Optional String objectId,
                                        @Param("arguments") @Optional List<CallArgument> arguments,
                                        @Param("silent") @Optional Boolean silent,
                                        @Param("returnByValue") @Optional Boolean returnByValue,
                                        @Param("generatePreview") @Optional @Experimental Boolean generatePreview,
                                        @Param("userGesture") @Optional Boolean userGesture,
                                        @Param("awaitPromise") @Optional Boolean awaitPromise,
                                        @Param("executionContextId") @Optional Integer executionContextId,
                                        @Param("objectGroup") @Optional String objectGroup);

    /**
     * Compiles expression.
     *
     * @param expression         Expression to compile.
     * @param sourceURL          Source url to be set for the script.
     * @param persistScript      Specifies whether the compiled script should be persisted.
     * @param executionContextId Specifies in which execution context to perform script run.
     *                           If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     * @return CompileScriptResult
     */
    CompileScriptResult compileScript(@Param("expression") String expression,
                                      @Param("sourceURL") String sourceURL,
                                      @Param("persistScript") boolean persistScript,
                                      @Param("executionContextId") @Optional Integer executionContextId);

    /**
     * Disables reporting of execution contexts creation.
     */
    void disable();

    /**
     * Discards collected exceptions and console API calls.
     */
    void discardConsoleEntries();

    /**
     * Enables reporting of execution contexts creation by means of executionContextCreated event.
     * When the reporting gets enabled the event will be sent immediately for each existing execution context.
     */
    void enable();

    /**
     * Evaluates expression on global object.
     *
     * @param expression            Expression to evaluate.
     * @param objectGroup           Symbolic group name that can be used to release multiple objects.
     * @param includeCommandLineAPI Determines whether Command Line API should be available during the evaluation.
     * @param silent                In silent mode exceptions thrown during evaluation are not reported and do not pause execution.
     *                              Overrides setPauseOnException state.
     * @param contextId             Specifies in which execution context to perform evaluation.
     *                              If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     * @param returnByValue         Whether the result is expected to be a JSON object that should be sent by value.
     * @param generatePreview       Whether preview should be generated for the result.
     * @param userGesture           Whether execution should be treated as initiated by user in the UI.
     * @param awaitPromise          Whether execution should await for resulting value and return once awaited promise is resolved.
     * @param throwOnSideEffect     Whether to throw an exception if side effect cannot be ruled out during evaluation.
     * @param timeout               Terminate execution after timing out (number of milliseconds).
     * @return EvaluateResult
     */
    EvaluateResult evaluate(@Param("expression") String expression,
                            @Param("objectGroup") @Optional String objectGroup,
                            @Param("includeCommandLineAPI") @Optional Boolean includeCommandLineAPI,
                            @Param("silent") @Optional Boolean silent,
                            @Param("contextId") @Optional Integer contextId,
                            @Param("returnByValue") @Optional Boolean returnByValue,
                            @Param("generatePreview") @Optional @Experimental Boolean generatePreview,
                            @Param("userGesture") @Optional Boolean userGesture,
                            @Param("awaitPromise") @Optional Boolean awaitPromise,
                            @Param("throwOnSideEffect") @Optional @Experimental Boolean throwOnSideEffect,
                            @Param("timeout") @Optional @Experimental Double timeout);

    /**
     * Evaluates expression on global object.
     *
     * @param expression Expression to evaluate.
     * @return EvaluateResult
     */
    EvaluateResult evaluate(@Param("expression") String expression);

    /**
     * Returns the isolate id.
     *
     * @return The isolate id.
     */
    @Experimental
    @Returns("id")
    String getIsolateId();

    /**
     * Returns the JavaScript heap usage.
     * It is the total usage of the corresponding isolate not scoped to a particular Runtime.
     *
     * @return GetHeapUsageResult
     */
    @Experimental
    GetHeapUsageResult getHeapUsage();

    /**
     * Returns properties of a given object.
     * Object group of the result is inherited from the target object.
     *
     * @param objectId               Identifier of the object to return properties for.
     * @param ownProperties          If true, returns properties belonging only to the element itself, not to its prototype chain.
     * @param accessorPropertiesOnly If true, returns accessor properties (with getter/setter) only; internal properties are not returned either.
     * @param generatePreview        Whether preview should be generated for the results.
     * @return
     */
    GetPropertiesResult getProperties(@Param("objectId") String objectId,
                                      @Param("ownProperties") @Optional Boolean ownProperties,
                                      @Param("accessorPropertiesOnly") @Optional @Experimental Boolean accessorPropertiesOnly,
                                      @Param("generatePreview") @Optional @Experimental Boolean generatePreview);

    /**
     * Returns all let, const and class variables from global scope.
     *
     * @param executionContextId Specifies in which execution context to lookup global scope variables.
     * @return names
     */
    @Returns("names")
    List<String> globalLexicalScopeNames(@Param("executionContextId") @Optional Integer executionContextId);

    /**
     * queryObjects
     *
     * @param prototypeObjectId Identifier of the prototype to return objects for.
     * @param objectGroup       Symbolic group name that can be used to release the results.
     * @return Array with objects.
     */
    @Returns("objects")
    RemoteObject queryObjects(@Param("prototypeObjectId") String prototypeObjectId,
                              @Param("objectGroup") @Optional String objectGroup);

    /**
     * Releases remote object with given id.
     *
     * @param objectId Identifier of the object to release.
     */
    void releaseObject(@Param("objectId") String objectId);

    /**
     * Releases all remote objects that belong to a given group.
     *
     * @param objectGroup Symbolic object group name.
     */
    void releaseObjectGroup(@Param("objectGroup") String objectGroup);

    /**
     * Tells inspected instance to run if it was waiting for debugger to attach.
     */
    void runIfWaitingForDebugger();

    /**
     * Runs script with given id in a given context.
     *
     * @param scriptId              Id of the script to run.
     * @param executionContextId    Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     * @param objectGroup           Symbolic group name that can be used to release multiple objects.
     * @param silent                In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides setPauseOnException state.
     * @param includeCommandLineAPI Determines whether Command Line API should be available during the evaluation.
     * @param returnByValue         Whether the result is expected to be a JSON object which should be sent by value.
     * @param generatePreview       Whether preview should be generated for the result.
     * @param awaitPromise          Whether execution should await for resulting value and return once awaited promise is resolved.
     * @return RunScriptResult
     */
    RunScriptResult runScript(@Param("scriptId") String scriptId,
                              @Param("executionContextId") @Optional Integer executionContextId,
                              @Param("objectGroup") @Optional String objectGroup,
                              @Param("silent") @Optional Boolean silent,
                              @Param("includeCommandLineAPI") @Optional Boolean includeCommandLineAPI,
                              @Param("returnByValue") @Optional Boolean returnByValue,
                              @Param("generatePreview") @Optional Boolean generatePreview,
                              @Param("awaitPromise") @Optional Boolean awaitPromise);

    /**
     * Enables or disables async call stacks tracking.
     *
     * @param maxDepth Maximum depth of async call stacks.
     *                 Setting to 0 will effectively disable collecting async call stacks (default).
     */
    void setAsyncCallStackDepth(@Param("maxDepth") int maxDepth);

    /**
     * setCustomObjectFormatterEnabled
     *
     * @param enabled enabled
     */
    @Experimental
    void setCustomObjectFormatterEnabled(@Param("enabled") boolean enabled);

    /**
     * setMaxCallStackSizeToCapture
     *
     * @param size size
     */
    @Experimental
    void setMaxCallStackSizeToCapture(@Param("size") int size);

    /**
     * Terminate current or next JavaScript execution.
     * Will cancel the termination when the outer-most script execution ends.
     */
    @Experimental
    void terminateExecution();

    /**
     * If executionContextId is empty,
     * adds binding with the given name on the global objects of all inspected contexts,
     * including those created later, bindings survive reloads.
     * If executionContextId is specified, adds binding only on global object of given execution context.
     * Binding function takes exactly one argument,
     * this argument should be string, in case of any other input, function throws an exception.
     * Each binding function call produces Runtime.bindingCalled notification.
     *
     * @param name               name
     * @param executionContextId executionContextId
     */
    @Experimental
    void addBinding(@Param("name") String name,
                    @Param("executionContextId") @Optional Integer executionContextId);

    /**
     * This method does not remove binding function from global object
     * but unsubscribes current runtime agent from Runtime.bindingCalled notifications.
     *
     * @param name name
     */
    @Experimental
    void removeBinding(@Param("name") String name);
}
