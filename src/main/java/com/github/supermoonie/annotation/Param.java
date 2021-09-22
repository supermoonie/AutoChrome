package com.github.supermoonie.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 参数注解
 *
 * @author supermoonie
 */
@Retention(RUNTIME)
@Target({PARAMETER})
public @interface Param {

    String value();
}
