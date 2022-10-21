package org.example.ex8;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class Logging {

//    @Before("execution(* getStudents())")
//    void beforeAllGetLogging(){ // едвайс
//        System.out.println("Логируем перед получением студентов");
//
//    }

//    @AfterReturning(value = "execution(* getStudents())", returning = "students")
//    void afterReturningGetStudents(List<Student> students){ // едвайс
//        System.out.println("Логируем после получения студентов");
//        for (Student student : students) {
//            student.setFullName(student.getFullName().toUpperCase());
//        }
//    }

//    @AfterThrowing(value = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudent(Exception exception){
//        System.out.println("Логіювання після виключної ситуації при отримання студентів");
//        System.out.println(exception);
//    }

    @After(value = "execution(* getStudents())")
    public void afterGetStudent(){
        System.out.println("Логируем после работы метода успешного или нет");
    }

    @Around(value = "execution(* getStudents())")
    public Object aroundGetStudents(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AROUND");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("AROUND");
        return result;
    }


}
// execution(modifiers-pattern? RETURN-TYPE-PATTERN declaring-type-pattern? METHOD-NAME-PATTERN(PARAMETER-PATTERN) throws-pattern)
