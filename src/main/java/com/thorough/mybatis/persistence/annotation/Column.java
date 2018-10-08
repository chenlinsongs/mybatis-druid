package com.thorough.mybatis.persistence.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chenlinsong on 2018/9/28.
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Column {
    String name();
}
