package org.example.ex6.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // пріоритет виконання
public class Security {

    //@Before("execution(* get*(..))")
    @Before("org.example.ex6.aspects.Pointcuts.allGetMethods()")
    void beforeAllGetSecurity(){
        System.out.println("- Перевірка прав доступу -");
    }
}
