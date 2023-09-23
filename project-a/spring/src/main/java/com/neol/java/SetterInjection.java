package com.neol.java;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// You can't use final fields
// You have to add a getter for every dependency
@Component
public class SetterInjection {
    private DependencyClass dependencyClass;

    @Autowired
    public void setDependencyClass(DependencyClass dependencyClass){
        this.dependencyClass = dependencyClass;
    }

    public String getValue(){
        return dependencyClass.getValue() + " Setter Injection";
    }
}
