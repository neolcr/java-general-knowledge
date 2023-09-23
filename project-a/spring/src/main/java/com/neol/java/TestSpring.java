package com.neol.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){

            ConstructorInjection constructorInjection = context.getBean(ConstructorInjection.class);
            ConstructorInjection constructorInjection1 = context.getBean(ConstructorInjection.class);
            System.out.println(constructorInjection.getValue());
            // Scope prototype they wont be same object
            System.out.println(constructorInjection == constructorInjection1);

            FieldInjection fieldInjection = context.getBean(FieldInjection.class);
            FieldInjection fieldInjection1 = context.getBean(FieldInjection.class);
            // Scope default singleton, they will be the same
            System.out.println(fieldInjection.getValue());
            System.out.println(fieldInjection == fieldInjection1);

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

    public static String beanScopes(){
        return "Singleton: only one instance across the application\n"+
                "Prototype: a new bean everytime it is requested\n" +
                "Request: a new bean instance for each HTTP request in a web app\n" +
                "Session: a new bean instance for each HTTP session in a web app\n" +
                "Application: a new bean instance is created for the entire lifecycle of a web app\n" +
                "Custom: CustomScopeConfigurer bean";
    }

    public static String whatIsSpringContainer(){
        return "Is responsible for managing the lifecycle of Spring Beans\n"+
                "Creates, configures, and manages beans and their dependencies based on config metadata\n"+
                "Two types: the old basic BeanFactory , ApplicationContext that is more complete, an extension of BeanFactory";
    }


}
