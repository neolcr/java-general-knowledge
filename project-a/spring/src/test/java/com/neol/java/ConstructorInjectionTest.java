package com.neol.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectionTest {

    @Mock
    private DependencyClass dependencyClass;

    private ConstructorInjection constructorInjection;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        constructorInjection = new ConstructorInjection(dependencyClass);
    }

    @DisplayName("Integration test one")
    @Test
    public void integrationTestA(){
        String result = "Esto es una prueba";
        Mockito.when(dependencyClass.getValue()).thenReturn(result);
        String value = constructorInjection.getValue();
        assertEquals(result + " Constructor Injection", value);
    }

}