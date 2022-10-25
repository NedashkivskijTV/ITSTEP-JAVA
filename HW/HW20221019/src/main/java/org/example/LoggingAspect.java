package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LoggingAspect {
    public static final String ALL_METHODS = "execution(* *(..))";

    @Before(ALL_METHODS)
    public void beforeAllMethodsAdvice(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); // отримання сигнатури методу бізнес-логіки
        //System.out.println("--- beforeAllMethodsAspect - " + "begin " + signature.getName() + " " + getCurrentTime());
        Writer.writeText("begin " + signature.getName() + "() " + getCurrentTime());
    }

    @After(ALL_METHODS)
    public void afterAllMethodsAdvice(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); // отримання сигнатури методу бізнес-логіки
        //System.out.println("--- afterAllMethodsAdvice - " + "end " + signature.getName() + " " + getCurrentTime());
        Writer.writeText("end " + signature.getName() + "() " + getCurrentTime());
    }

    private String getCurrentTime(){
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss"); // форматування часу
        Date date = new Date(); // отримання поточної дати та часу
        return formater.format(date);
    }
}
