package com.neol.oop;

public class TestInterfaceClass{
    public static void main(String[] args) {

    }
}

// ALL FIELDS ARE PUBLIC, STATIC AND FINAL
interface MyInterface {
    // IT CANT private String privateField;
    // IT CANT public String publicField;
    // IT CANT protected String protectedField;
    // IT CANT static String staticField;
    public static final String publicStaticFinal = "PUBLIC_STATIC_FINAL";


    // IT CANT public MyInterface(){}

    public default String getPrivateField() {
        return publicStaticFinal;
    }

    private String privateMethod() {
        return publicStaticFinal;
    }


    abstract void doSomething();
}

class Implementor implements MyInterface{

    @Override
    public void doSomething() {
        System.out.println("Im the inheritor");
    }
}
