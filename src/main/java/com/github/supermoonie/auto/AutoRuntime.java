package com.github.supermoonie.auto;

import com.github.supermoonie.command.Runtime;
import com.github.supermoonie.condition.Condition;
import com.github.supermoonie.condition.ExpressionsCondition;
import com.github.supermoonie.event.Event;
import com.github.supermoonie.exception.JavaScriptException;
import com.github.supermoonie.listener.AbstractEventListener;
import com.github.supermoonie.listener.BaseEventListener;
import com.github.supermoonie.listener.DefaultNetworkListener;
import com.github.supermoonie.todo.Todo;
import com.github.supermoonie.type.network.GetResponseBodyResult;
import com.github.supermoonie.type.runtime.EvaluateResult;
import com.github.supermoonie.type.runtime.RemoteObject;
import org.slf4j.Logger;

import java.util.concurrent.atomic.AtomicReference;

import static com.github.supermoonie.util.StringUtils.isEmpty;

/**
 * @author supermoonie
 * @date 2018/11/28
 */
public interface AutoRuntime extends Auto {

    /**
     * eval until dialog or expression check ok
     *
     * @param expression    expression
     * @param expectTrueExp expression which expect true
     * @param timeout       timeout
     * @return result
     */
    default boolean evalUntilDialogOrCheckOk(String expression, String expectTrueExp, long timeout) {
        Condition condition = autoChrome -> {
            if (null != autoChrome.getJavascriptDialogOpening()) {
                return Boolean.FALSE;
            }
            Object result = autoChrome.eval(expectTrueExp);
            if (null != result && (Boolean) result) {
                return Boolean.TRUE;
            }
            return null;
        };
        return evalUntil(expression, condition, timeout);
    }

    /**
     * eval until expression check finished
     *
     * @param expression     expression
     * @param expectTrueExp  expression to check success
     * @param expectFalseExp expression to check fail
     * @param timeout        timeout
     * @return If check success return true, else return false.
     */
    default boolean evalUntilCheckFinished(String expression, String expectTrueExp, String expectFalseExp, long timeout) {
        return evalUntil(expression, new ExpressionsCondition(expectTrueExp, expectFalseExp), timeout);
    }

    /**
     * eval expression until match url data received
     *
     * @param expression expression
     * @param matchUrl   match url
     * @param timeout    timeout
     * @return body
     */
    default GetResponseBodyResult evalUntilDataReceived(String expression, String matchUrl, long timeout) {
        if (isEmpty(expression)) {
            throw new IllegalArgumentException("expression is empty!");
        }
        Todo<Void> todo = autoChrome -> {
            autoChrome.evaluate(expression);
            return null;
        };
        DefaultNetworkListener listener = new DefaultNetworkListener(matchUrl);
        AutoChrome chrome = getThis();
        chrome.waitEvent(todo, listener, timeout);
        String requestId = listener.getRequestId();
        return chrome.getNetwork().getResponseBody(requestId);
    }

    /**
     * eval until
     *
     * @param expression expression
     * @param condition  condition
     * @param timeout    timeout
     * @return result
     */
    default boolean evalUntil(String expression, Condition condition, long timeout) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s, %d)", expression, condition, timeout));
        autoChrome.evaluate(expression);
        return autoChrome.waitCondition(condition, timeout);
    }

    /**
     * eval until
     *
     * @param expression      expression
     * @param event           event
     * @param timeout         timeout
     * @param resultReference result referenc
     * @return EvaluateResult
     */
    default EvaluateResult evalUntil(String expression, Event event, long timeout, AtomicReference<Object> resultReference) {
        if (null == event) {
            throw new NullPointerException("event is null!");
        }
        Todo<EvaluateResult> todo = autoChrome -> autoChrome.evaluate(expression);
        AbstractEventListener listener = new BaseEventListener(event, resultReference);
        return getThis().waitEvent(todo, listener, timeout);
    }

    /**
     * eval
     *
     * @param expression expression
     * @return Object
     */
    default Object eval(String expression) {
        if (isEmpty(expression)) {
            throw new IllegalArgumentException("expression is empty!");
        }
        Runtime runtime = getThis().getRuntime();
        EvaluateResult evaluateResult = runtime.evaluate(expression);
        if (null == evaluateResult) {
            return null;
        }
        if (null != evaluateResult.getExceptionDetails()) {
            throw new JavaScriptException(evaluateResult.getExceptionDetails().getException().getDescription());
        }
        RemoteObject remoteObject = evaluateResult.getResult();
        if (null == remoteObject) {
            return null;
        }
        String objectId = remoteObject.getObjectId();
        if (null != objectId) {
            runtime.releaseObject(objectId);
        }
        return remoteObject.getValue();
    }

    /**
     * evaluate
     *
     * @param expression expression
     * @return EvaluateResult
     */
    default EvaluateResult evaluate(String expression) {
        if (isEmpty(expression)) {
            throw new IllegalArgumentException("expression is empty!");
        }
        EvaluateResult evaluateResult = getThis().getRuntime().evaluate(expression);
        if (null == evaluateResult) {
            return null;
        }
        if (null != evaluateResult.getExceptionDetails()) {
            throw new JavaScriptException(evaluateResult.getExceptionDetails().getException().getDescription());
        }
        return evaluateResult;
    }
}
