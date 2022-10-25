package repeat.ex8;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class Logging {

//    @Before("execution(* getStudents())")
//    void beforeGetStudentsAspect(){
//        System.out.println("--- Логіювання перед отриманням студентів");
//    }


////    @AfterReturning("execution(* getStudents())") // варіант без доступу до поверненого значення (для доступу потрібно змінити параметри)
////    void afterReturningGetStudentsAspect(){  // варіант без доступу до поверненого значення (для доступу потрібно змінити параметри)
//    @AfterReturning(value = "execution(* getStudents())", returning = "students") // варіант з доступом до поверненого значення
//    void afterReturningGetStudentsAspect(List<Student> students){  // варіант з доступом до поверненого значення
//        System.out.println("--- Логіювання перед отриманням студентів");
//        for (Student student : students) {
//            student.setFullName(student.getFullName().toUpperCase());
//        }
//    }

//    //@AfterThrowing("execution(* getStudents())") // без доступу до внутрішньої інф
//    //public void afterThrowingGetStudents(){ // без доступу до внутрішньої інф
//    @AfterThrowing(value = "execution(* getStudents())", throwing = "exception") // доступ до будь-якої інформації у помилці
//    public void afterThrowingGetStudents(Exception exception){ // доступ до будь-якої інформації у помилці
//        System.out.println("--- Логіювання після виключної ситуації під час отримання студентів");
//        System.out.println(exception.getMessage());
//    }

//    @After("execution(* getStudents())")
//    public void afterGetStudents(){
//        System.out.println("--- Логіювання після роботи методу успішної або ні");
//    }

    @Around("execution(* getStudents())")
    public Object aroundGetStudents(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // ProceedingJoinPoint - отримає доступ до всього методу бізнес-логіки
        System.out.println("--- AROUND");
        Object result = proceedingJoinPoint.proceed(); // .proceed() - директива на запуска методу бізнес-логіки
        System.out.println("--- AROUND");
        return result;
    }

}
