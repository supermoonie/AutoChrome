package com.github.supermoonie.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 方法域注解
 *
 * @author supermoonie
 */
@Retention(RUNTIME)
@Target({TYPE})
public @interface Domain {

    String value();
}
