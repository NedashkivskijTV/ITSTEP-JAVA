package repeat.ex6.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // на клас-аспект - визначає рейтинг-порядок виконання Єдвайсів, менше число - вищий пріоритет
// (ціле число 0 - макс значення int, за замовчуванням - найбільше число int), якщо @Order однаковий порядок визначається при  порівнянні імен Єдвайсів
public class Security {

    //@Before("execution(* get*(..))")
    @Before("org.example.ex6.aspects.Pointcuts.allGetMethods()")
    void beforeAllGetSecurity(){
        System.out.println("--- перевірка прав доступу ---");
    }
}
