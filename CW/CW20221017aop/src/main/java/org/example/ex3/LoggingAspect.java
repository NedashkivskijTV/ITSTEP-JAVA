package org.example.ex3;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
//    public static final String BEFORE_OLL_GET = "execution(* get*(..))";
//
//    //@Before("execution(* get*(..))")
//    @Before(BEFORE_OLL_GET)
//    public void beforeGetLogging() {
//        System.out.println("logging");
//    }
//
//    //@Before("execution(* get*(..))")
//    @Before(BEFORE_OLL_GET)
//    public void beforeGetSecurity() {
//        System.out.println("security");
//    }

    @Pointcut("execution(* get*(..))")
    private void allGetMethod(){} // метод для конфігурації

    //@Before("execution(* get*(..))")
    //@Before(BEFORE_OLL_GET)
    @Before("allGetMethod()")
    public void beforeGetLogging() {
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