package com.neol.java.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.neol.java.spring")
@EnableAspectJAutoProxy
public class AppConfig {
}
