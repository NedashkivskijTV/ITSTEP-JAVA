package edu.itstep.cw20221003.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FirstAnnotation {
    int KEY = 7;

    int key1();
}
