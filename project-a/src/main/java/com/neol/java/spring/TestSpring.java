package com.neol.java.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){

            ConstructorInjection constructorInjection = context.getBean(ConstructorInjection.class);
            System.out.println(constructorInjection.getValue());

            FieldInjection fieldInjection = context.getBean(FieldInjection.class);
            System.out.println(fieldInjection.getValue());

            SetterInjection setterInjection = context.getBean(SetterInjection.class);
            System.out.println(setterInjection.getValue());

        }

    }

    public static String getSpringCoreConcepts(){
        return "Dependency Injection (DI)\n" +
                "Aspect Oriented Programming (AOP)\n"+
                "Spring Container\n" +
                "Modules: Spring MVC, Spring Security, Spring Boot"
                ;
    }

    public static String whatIsDependencyInjection(){
        return "Desing Pattern in which components receive their dependencies rather than creating them\n" +
                "Spring DI is implemented by constructors, setters, or method injection\n"+
                "Is managed by the Spring IoC (Inversion of Control) Container"
                ;
    }


}
