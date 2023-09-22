package com.neol.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Can use final attributes
// You can define dependencies in unit test directly when you create the instance of a bean to test
// You need to add possible many code to the constructor (unless using Lombok)
@Component
public class ConstructorInjection {
    private final DependencyClass dependencyClass;

    // Autowired is optional here
    @Autowired
    public ConstructorInjection(DependencyClass dependencyClass) {
        this.dependencyClass = dependencyClass;
    }

    public String getValue(){
        return dependencyClass.getValue() + " Constructor Injection";
    }
}
