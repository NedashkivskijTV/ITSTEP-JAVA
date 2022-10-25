package repeat.ex2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect { // Aspect
//    // сдужбова логіка спрацює
//    // перед усіма методами, з будь-якою назвою
//    // в усіх класах проекту,
//    // у яких є 1 параметр, що має тип int,
//    // модифікатор доступу не вказано
//    @Before("execution(* *(int))") // pointcut
//    public void beforeParamsIntAdvice(){ // Advice
//        System.out.println("--- beforeParamsIntAdvice: ---");
//    }

//    // сдужбова логіка спрацює
//    // перед усіма методами, з будь-якою назвою
//    // в усіх класах проекту,
//    // у яких є 1 параметр, що має ,будь-який тип
//    // модифікатор доступу не вказано
//    @Before("execution(* *(*))") // pointcut
//    public void beforeOneParamAdvice(){ // Advice
//        System.out.println("--- beforeOneParamAdvice: ---");
//    }

//    // сдужбова логіка спрацює
//    // перед усіма методами, з будь-якою назвою
//    // в усіх класах проекту,
//    // у яких параметри будь-якої кількості (або ніяких) та будь-яких типів - вказано .. - байдуже які та скільки
//    // модифікатор доступу не вказано
//    @Before("execution(* *(..))") // pointcut
//    public void beforeAllAdvice(){ // Advice
//        System.out.println("--- beforeAllAdvice: global ---");
//    }

    // службова логіка спрацює
    // перед усіма методами, з будь-якою назвою
    // в усіх класах проекту,
    // у яких перший параметр типу String, а решта параметрів - будь-якої кількості (або ніяких) та будь-яких типів - .. - байдуже які та скільки
    // модифікатор доступу не вказано
    @Before("execution(* *(String, ..))") // pointcut
    public void beforeFirstParamStringAdvice(){ // Advice
        System.out.println("--- beforeFirstParamStringAdvice: -------");
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
