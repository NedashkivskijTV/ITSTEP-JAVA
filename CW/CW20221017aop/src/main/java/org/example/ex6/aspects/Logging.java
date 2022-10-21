package org.example.ex6.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Logging {

    //@Before("execution(* get*(..))")
    @Before("org.example.ex6.aspects.Pointcuts.allGetMethods()")
    void beforeAllGetLogging(){
        System.out.println("- Логірування -");
    }

}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN declaring-type-pattern? METHOD-NAME-PATTERN(PARAMETER-PATTERN) throws-pattern)
