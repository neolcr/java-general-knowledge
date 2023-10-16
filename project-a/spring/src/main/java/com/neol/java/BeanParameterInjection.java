package com.neol.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanParameterInjection {

    // DependencyClass will be injected
    @Bean
    public String example(DependencyClass dependencyClass){
        return dependencyClass.getValue();
    }
}
