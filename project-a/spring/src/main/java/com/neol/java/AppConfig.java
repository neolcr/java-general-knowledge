package com.neol.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.neol.java")
@EnableAspectJAutoProxy
public class AppConfig {
}
