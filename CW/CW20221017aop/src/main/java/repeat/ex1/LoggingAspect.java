package repeat.ex1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect { // Aspect

//    // сдужбова логіка спрацює перед методом явно вказаним у дужках ...getBook()
//    @Before("execution(public void repeat.ex1.UniversityLibrary.getBook())") // pointcut
//    public void beforeGetBookAdvice(){ // Advice
//        System.out.println("--- beforeGetBookAdvice: хтось взяв книгу ---");
//    }

//    // сдужбова логіка спрацює перед усіма гетерами у класі UniversityLibrary, у яких немає параметрів, повернене значення void
//    @Before("execution(public void repeat.ex1.UniversityLibrary.get*())") // pointcut
//    public void beforeAllGetUniversityLibraryAdvice(){ // Advice
//        System.out.println("--- beforeAllGetUniversityLibraryAdvice: хтось взяв книгу ---");
//    }

//    // сдужбова логіка спрацює перед усіма гетерами у класі UniversityLibrary, у яких немає параметрів, повернене значення * - будь-яке
//    @Before("execution(public * repeat.ex1.UniversityLibrary.get*())") // pointcut
//    public void beforeAllGetUniversityLibraryAdvice(){ // Advice
//        System.out.println("--- beforeAllGetUniversityLibraryAdvice: хтось взяв книгу ---");
//    }

//    // сдужбова логіка спрацює перед усіма методами, в назві яких міститься Book (на початку та в кінці * - ігнорується) у класі UniversityLibrary,
//    // у яких немає параметрів, повернене значення * - будь-яке
//    @Before("execution(public * repeat.ex1.UniversityLibrary.*Book*())") // pointcut
//    public void beforeBookUniversityLibraryAdvice(){ // Advice
//        System.out.println("--- beforeBookUniversityLibraryAdvice: маніпуляція з книгою ---");
//    }

//    // сдужбова логіка спрацює перед усіма методами, в назві яких міститься Book (на початку та в кінці * - ігнорується)
//    // в усіх класах проекту,
//    // у яких немає параметрів, повернене значення * - будь-яке
//    @Before("execution(public * *Book*())") // pointcut
//    public void beforeBookAdvice(){ // Advice
//        System.out.println("--- beforeBookAdvice: маніпуляція з книгою ---");
//    }

    // сдужбова логіка спрацює перед усіма методами, з будь-якою назвою
    // в усіх класах проекту,
    // у яких немає параметрів, повернене значення * - будь-яке
    @Before("execution(public * *())") // pointcut
    public void beforeAllMethodsWithoutParamsAdvice(){ // Advice
        System.out.println("--- beforeAllMethodsWithoutParamsAdvice: ---");
    }

}

// execution(modifiers-pattern? RETURN-TYPE-PATTERN declaring-type-pattern? METHOD-NAME-PATTERN(PARAMETER-PATTERN)throws-pattern?)
//        -	execution – директива для компілятора на виконання у якості поінткату
//        -	modifiers-pattern? – НЕ обов’язковий, паттерн модифікатора доступу, тип модифікатора доступу метода, використовуються усі крім private (для приватних методів службова логіка НЕ застосовується)
//        -	RETURN-TYPE-PATTERN – ОБОВ’ЯЗКОВИЙ, тип поверненого значення
//        -	declaring-type-pattern? – НЕ обов’язковий, шлях до класу, клас в якому описано потрібний метод
//        -	METHOD-NAME-PATTERN – ОБОВ’ЯЗКОВИЙ, назва потрібного методу
//        -	PARAMETER-PATTERN – ОБОВ’ЯЗКОВИЙ, параметри методу
//        -	throws-pattern? – НЕ обов’язковий, вказується, що метод може згенерувати виключну ситуацію
