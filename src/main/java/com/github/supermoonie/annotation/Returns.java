package com.github.supermoonie.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 返回值注解
 *
 * @author supermoonie
 */
@Retention(RUNTIME)
@Target({METHOD})
public @interface Returns {

    String value();
}
