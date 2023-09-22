package com.neol.java.spring;

import org.springframework.stereotype.Component;

@Component
public class DependencyClass {
    public String getValue(){
        return "value";
    }
}
