package repeat.ex5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect { // Aspect

    // Виконання службової логіки для усіх методів окрім одного add*

    @Pointcut("execution(* *(..))")
    private void allMethods(){}

    @Pointcut("execution(* add*(..))")
    private void addMethod(){}

    @Before("allMethods() && !addMethod()")
    public void beforeAllMethodsExceptAdd(){
        System.out.println("--- beforeAllMethodsExceptAdd ---");
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
