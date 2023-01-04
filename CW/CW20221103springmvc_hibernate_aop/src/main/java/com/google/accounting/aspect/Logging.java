package com.google.accounting.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component // на клас, ознака необхідності створення bean-а на основі даного об'єкта – спеціальний маркер, яким помічається той клас, з котрого потрібно буде створити bean – при створенні SpringContainer, останній звертається до конфігураційного файлу, де читає рядок, в якому міститься інф, що потрібно відсканувати вказаний перкедж на предмет наявності у класів анотації @Component та створення на їх основі бінів. Може використовуватись з вказанням id біна (@Component("myCat")).
@Aspect // на класи-аспекти, помічаються класи зі службовою логікою
public class Logging {

    @Around("execution(* com.google.accounting.repository.*.*(..))")
    // @Around - тип Advice-а - вид анотації поінткату, що відповідає за час (КОЛИ САМЕ) виконання єдвайсу (службової логіки) – ДО та ПІСЛЯ СПРАЦЮВАННЯ спрацювання бізнес-логіки – для роботи потрібно у службовій логіці отримати доступ до самого метода – перехоплює та підміняє повернене методом значення
    // "execution(* com.google.accounting.repository.*.*(..))" – шаблон – (вказує ДЛЯ КОГО виконується службова логіка) – в дужках вказується потрібний поінткат
    public Object aroundAllRepositoryMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("Start of " + methodName);
        Object result = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);
        return result;
    }
}
