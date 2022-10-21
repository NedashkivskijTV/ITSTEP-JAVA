package org.example.ex4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* set*(..))")
    private void allSetMethod(){} // метод для конфігурації
    @Pointcut("execution(* get*(..))")
    private void allGetMethod(){} // метод для конфігурації

    //@Before("execution(* get*(..))")
    //@Before(BEFORE_OLL_GET)
    @Before("allGetMethod() || allSetMethod()")
    public void beforeGetAndSetLogging() {
        System.out.println("logging");
    }

    //@Before("execution(* get*(..))")
    //@Before(BEFORE_OLL_GET)
    @Before("allGetMethod()")
    public void beforeGetSecurity() {
        System.out.println("security");
    }



}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN )