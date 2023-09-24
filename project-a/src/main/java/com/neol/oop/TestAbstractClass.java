package com.neol.oop;

public class TestAbstractClass{
    public static void main(String[] args) {
        Inheritor inheritor = new Inheritor("private", "public", "protected");
        // IT CAN'T AbstractClass abstractClass = new AbstractClass();

        System.out.println(inheritor.getPublicField());
        System.out.println(inheritor.getPrivateField());
        System.out.println(inheritor.getProtectedField());
        System.out.println(Inheritor.getStaticField());
        inheritor.doSomething();
    }
}

abstract class AbstractClass {
    private String privateField;
    public String publicField;
    protected String protectedField;
    static String staticField;

    public AbstractClass(String privateField, String publicField, String protectedField) {
        this.privateField = privateField;
        this.publicField = publicField;
        this.protectedField = protectedField;
    }

    public AbstractClass(){}

    public String getPrivateField() {
        return privateField;
    }

    public String getPublicField() {
        return publicField;
    }

    public String getProtectedField() {
        return protectedField;
    }

    public static String getStaticField() {
        return staticField;
    }

    abstract void doSomething();
}

class Inheritor extends AbstractClass{

    public Inheritor(String privateField, String publicField, String protectedField) {
        super(privateField, publicField, protectedField);
    }

    @Override
    void doSomething() {
        System.out.println("Im the inheritor");
    }
}
