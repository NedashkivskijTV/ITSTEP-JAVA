package org.example.ex5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* * (..))")
    private void allMethods(){}

    @Pointcut("execution(* add* (..))")
    private void addMethods(){}

    @Before("allMethods() && !addMethods()") // єдвайс
    public void beforeAllMethodsExceptAdd(){
        System.out.println("beforeAllMethodsExceptAdd");
    }

}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN )
