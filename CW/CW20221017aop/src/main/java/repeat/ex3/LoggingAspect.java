package repeat.ex3;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect { // Aspect

//    // Якщо потрібно виконати різни види службової логіки для однакових поінткатів
//    public static final String BEFORE_ALL_GET = "execution(* get*(..))";
//
//    // службова логіка спрацює
//    // перед усіма методами, що містять на початку назви get
//    // в усіх класах проекту,
//    // з будь-якими параметрами
//    // модифікатор доступу не вказано
//    //@Before("execution(* get*(..))")
//    @Before(BEFORE_ALL_GET)
//    public void beforeGetLogging() {
//        System.out.println("--- Logging ---");
//    }
//
//    //@Before("execution(* get*(..))")
//    @Before(BEFORE_ALL_GET)
//    public void beforeGetSecurity() {
//        System.out.println("--- Security ---");
//    }

    // Якщо потрібно виконати різни види службової логіки для різних поінткатів
    @Pointcut("execution(* get*(..))")
    private void allGetMethod(){} // метод використовується як змінна котра зберігає в собі інф, що міститься як параметр анотації @Pointcut

    // службова логіка спрацює
    // перед усіма методами, що містять на початку назви get
    // в усіх класах проекту,
    // з будь-якими параметрами
    // модифікатор доступу не вказано
    //@Before("execution(* get*(..))")
    @Before("allGetMethod()")
    public void beforeGetLogging() {
        System.out.println("--- Logging ---");
    }

    //@Before("execution(* get*(..))")
    @Before("allGetMethod()")
    public void beforeGetSecurity() {
        System.out.println("--- Security ---");
    }


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
