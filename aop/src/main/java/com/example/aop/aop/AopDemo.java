package com.example.aop.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopDemo {

    @Pointcut("execution(public * com.example..*(..))")
    public void point() {
    }


    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("start");
        Object proceed = joinPoint.proceed();
        System.out.println("end");
        long end = System.currentTimeMillis();

        System.out.println("此次耗时： " + (end - start));

        return proceed;
    }
}
