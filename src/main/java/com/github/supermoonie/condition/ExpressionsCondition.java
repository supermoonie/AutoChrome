package com.github.supermoonie.condition;

import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.type.runtime.EvaluateResult;

import static com.github.supermoonie.util.StringUtils.isEmpty;

/**
 * @author wangchao
 * @date 2018/11/30 23:35
 */
public class ExpressionsCondition implements Condition {

    private final String expectTrueExpression;

    private final String expectFalseExpression;

    public ExpressionsCondition(String expectTrueExpression, String expectFalseExpression) {
        if (isEmpty(expectTrueExpression)) {
            throw new IllegalArgumentException("expression which expect true empty!");
        }
        if (isEmpty(expectFalseExpression)) {
            throw new IllegalArgumentException("expression which expect false empty!");
        }
        this.expectTrueExpression = expectTrueExpression;
        this.expectFalseExpression = expectFalseExpression;
    }

    @Override
    public Boolean apply(AutoChrome autoChrome) {
        EvaluateResult successResult = autoChrome.evaluate(expectTrueExpression);
        if (null == successResult.getExceptionDetails() &&
                null != successResult.getResult() &&
                (Boolean) successResult.getResult().getValue()) {
            return true;
        }
        EvaluateResult failResult = autoChrome.evaluate(expectFalseExpression);
        if (null == failResult.getExceptionDetails() &&
                null != failResult.getResult() &&
                (Boolean) failResult.getResult().getValue()) {
            return false;
        }
        return null;
    }
}
