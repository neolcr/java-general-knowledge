package com.neol.java;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
// Aspect Oriented Programming
// Allows to separete cross-cutting concerns (logging, etc) from the bussines logic
// making code more modular and manteinable
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.neol.java.*.*(..))")
    public void logBeforeServiceMethods(){
        System.out.println("I run before execution");
    }

    @After("execution(* com.neol.java.*.*(..))")
    public void logAfterServiceMethods(){
        System.out.println("I run after execution");
    }
}
