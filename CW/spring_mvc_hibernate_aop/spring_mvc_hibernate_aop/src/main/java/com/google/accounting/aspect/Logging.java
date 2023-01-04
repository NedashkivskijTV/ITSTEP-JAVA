package com.google.accounting.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

    @Around("execution(* com.google.accounting.repasitory.*.*(..))")
    public Object aroundAllRepositoryMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("Start of " + methodName);
        Object result = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);
        return result;
    }
}
