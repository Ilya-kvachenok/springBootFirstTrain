package com.tms.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAsp {

    @Around("@annotation(LogAop)")
    public Object printBefAndAft (ProceedingJoinPoint joinPoint) throws Throwable {
        double start = System.nanoTime() / 1_000_000.0;
        Object result = joinPoint.proceed();
        double duration = (System.nanoTime() - start) / 1_000_000.0;
        System.out.println("Start: " + start + " Duration: " + duration);
        return result;
    }
}
