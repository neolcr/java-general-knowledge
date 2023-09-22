package com.neol.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// Shortest way of inject a dependency
// Can't use final fields
// More difficult to set a mock depedency in a unit test
@Component
public class FieldInjection {
    @Autowired
    private DependencyClass dependencyClass;

    public String getValue(){
        return dependencyClass.getValue() + " Field injection";
    }
}
