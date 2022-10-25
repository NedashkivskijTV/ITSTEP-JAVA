package repeat.ex7.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(2) // на клас-аспект - визначає рейтинг-порядок виконання Єдвайсів, менше число - вищий пріоритет
// (ціле число 0 - макс значення int, за замовчуванням - найбільше число int), якщо @Order однаковий порядок визначається при  порівнянні імен Єдвайсів
public class Logging {

    @Before("execution(* get*(..))")
    void beforeAllGetLogging(JoinPoint joinPoint){
        //System.out.println("--- логіювання ---");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); // інформація про сігнатури метода, відносно якого виконується Єдвайс
//        System.out.println("--- " + signature.getMethod()); // повна інф про метод
//        System.out.println("--- " + signature.getName()); // назва методу
//        System.out.println("--- " + signature.getReturnType()); // тип поверненого значення

        Object[] args = joinPoint.getArgs(); // метод для отримання аргументів з якими був викликаний метод
        if(args.length == 0){
            System.out.println("--- логирование: метод " + signature.getName() + " викликаний без параметрів");
        } else {
            //System.out.println("--- логирование: метод " + signature.getName() + " викликаний з параметром: " + ("" + args[0]).toUpperCase());
            System.out.println("--- логирование: метод " + signature.getName() + " викликаний з параметром: " + ("" + args[0]).toUpperCase() + "; тип даних: " + args[0].getClass().getSimpleName());
        }
    }
}
