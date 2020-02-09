package com.github.supermoonie.condition;

import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.util.StringUtils;

/**
 * @author supermoonie
 * @since 2019/3/12
 */
public class ExpressionReturnTrueCondition implements Condition {

    private final String expression;

    public ExpressionReturnTrueCondition(String expression) {
        if (StringUtils.isEmpty(expression)) {
            throw new IllegalArgumentException("expression is empty!");
        }
        this.expression = expression;
    }


    @Override
    public Boolean apply(AutoChrome autoChrome) {
        if ((boolean) autoChrome.eval(expression)) {
            return Boolean.TRUE;
        }
        return null;
    }
}
