package edu.itstep.cw20221003_repeat.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecondAnnotation {
    // Для параметрів можуть використовуватись лише примітивні типи даних та String та ENUM
    String[] key();
    String[] value(); // value - при використанні даного ключового слова для іменування парметра
                      // при встановленні анотації (з 1 параметром !!!) данний параметр може використовуватись без вказання імені
                      // @SecondAnnotation("three") ; @SecondAnnotation(value = "three")

    enum Color{
        RED, GREEN, BLUE
    }

    Color param(); // визначення анотації з даним параметром
    // - @SecondAnnotation(value = "three", key = {"one", "two"}, param = SecondAnnotation.Color.RED)

}
