package repeat.ex4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect { // Aspect

//    // Якщо потрібно виконати різни види службової логіки для однакових поінткатів
    public static final String BEFORE_ALL_GET = "execution(* get*(..))";
    public static final String BEFORE_ALL_SET = "execution(* set*(..))";

   @Before(BEFORE_ALL_GET + "||" + BEFORE_ALL_SET)
    public void beforeGetLogging() {
        System.out.println("--- Logging ---");
    }

//    // Якщо потрібно виконати службову логіку для різних поінткатів
//    @Pointcut("execution(* get*(..))")
//    private void allGetMethod(){} // метод використовується як змінна котра зберігає в собі інф, що міститься як параметр анотації @Pointcut
//
//    @Pointcut("execution(* set*(..))")
//    private void allSetMethod(){} // метод використовується як змінна котра зберігає в собі інф, що міститься як параметр анотації @Pointcut
//
//    // службова логіка спрацює
//    // перед усіма методами, що містять на початку назви get та set
//    // в усіх класах проекту,
//    // з будь-якими параметрами
//    // модифікатор доступу не вказано
//   @Before("allGetMethod() || allSetMethod()ll")
//    public void beforeGetAndSetLogging() {
//        System.out.println("--- Logging ---");
//    }


}

// pointcut - шаблон
// execution(modifiers-pattern? RETURN-TYPE-PATTERN declaring-type-pattern? METHOD-NAME-PATTERN(PARAMETER-PATTERN)throws-pattern?)
//        -	execution – директива для компілятора на виконання у якості поінткату
//        -	modifiers-pattern? – НЕ обов’язковий, паттерн модифікатора доступу, тип модифікатора доступу метода, використовуються усі крім private (для приватних методів службова логіка НЕ застосовується)
//        -	RETURN-TYPE-PATTERN – ОБОВ’ЯЗКОВИЙ, тип поверненого значення
//        -	declaring-type-pattern? – НЕ обов’язковий, шлях до класу, клас в якому описано потрібний метод
//        -	METHOD-NAME-PATTERN – ОБОВ’ЯЗКОВИЙ, назва потрібного методу
//        -	PARAMETER-PATTERN – ОБОВ’ЯЗКОВИЙ, параметри методу
//        -	throws-pattern? – НЕ обов’язковий, вказується, що метод може згенерувати виключну ситуацію
