package org.example.ex2;

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

//    @Before("execution(* *(*))") // поінткат
//    public void beforeParamsInt(){
//        System.out.println("любий параметр");
//    }

//    @Before("execution(* *(..))") // поінткат
//    public void beforeGlobal(){
//        System.out.println("oll methods");
//    }

    @Before("execution(* *(String,..))") // поінткат
    public void beforeFirstParamString(){
        System.out.println("beforeFirstParamString");
    }


}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN )