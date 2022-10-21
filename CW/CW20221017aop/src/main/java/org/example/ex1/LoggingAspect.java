package org.example.ex1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(public void org.example.oldEx.UniversityLibrary.getBook())") // поінткат
//    public void beforeGetBookAdvice(){
//        System.out.println("beforeGetBookAdvice : хтось взяв книгу/журнал");
//    }

    //@Before("execution(public void org.example.oldEx.UniversityLibrary.get*())") // поінткат
//    @Before("execution(public * org.example.oldEx.UniversityLibrary.get*())") // поінткат
//    public void beforeGetUniversityLibraryAdvice(){
//        System.out.println("beforeGetUniversityLibraryAdvice : хтось взяв книгу/журнал");
//    }

//    @Before("execution(public * *Book*())") // поінткат
//    public void beforeBookAdvice(){
//        System.out.println("beforeBookAdvice : маніпуляція з книгою");
//    }

    @Before("execution(public * *())") // поінткат
    public void beforeOllMethodsWithoutParamsAdvice(){
        System.out.println("beforeOllMethodsWithoutParamsAdvice : ------------------------ ");
    }

}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN )