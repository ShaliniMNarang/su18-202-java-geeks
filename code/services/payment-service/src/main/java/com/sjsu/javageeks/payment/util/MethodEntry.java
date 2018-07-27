package com.sjsu.javageeks.payment.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;


@Aspect
@Configuration
public class MethodEntry {
    @Before("execution(* com.sjsu.javageeks.payment.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println(" Entered Method "+joinPoint.toString());
    }
}
