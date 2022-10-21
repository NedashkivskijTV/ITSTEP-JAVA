package org.example.ex7.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

    @Before("execution(* get*(..))")
    void beforeAllGetLogging(JoinPoint joinPoint){ // едвайс
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();
        if(args.length == 0){
            System.out.println("логирование : " + signature.getName() + " вызван без параметров");
        }else {
            System.out.println("логирование : " + signature.getName() + " вызван с параметром " + ("" + args[0]).toUpperCase() + " тип " + args[0].getClass().getSimpleName());
        }
    }

}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN declaring-type-pattern? METHOD-NAME-PATTERN(PARAMETER-PATTERN) throws-pattern)
