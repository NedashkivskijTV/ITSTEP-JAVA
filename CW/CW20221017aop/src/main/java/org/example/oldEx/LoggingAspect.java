package org.example.oldEx;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(* *(int))") // поінткат
//    public void beforeParamsInt(){
//        System.out.println("INT");
//    }

    @Before("execution(* *(*))") // поінткат
    public void beforeParamsInt(){
        System.out.println("любий параметр");
    }

}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN )