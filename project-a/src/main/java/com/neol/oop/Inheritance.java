package com.neol.oop;

abstract class Parent{
    abstract void doSomething();
}

// Inheritance is a mechanism that allows a class (subclass or derived class) to inherit properties and behaviors (attributes and methods)
// from another class (superclass or base class). It enables the creation of a new class based on an existing class, promoting code reuse.

// Reusability: allows you to reuse the attributes and methods of an existing class, reducing code duplication and promoting a more efficient development process.
// Extensibility: You can create new classes that extend the functionality of existing classes, adding or overriding methods as needed.
// Hierarchical Structure: Inheritance supports the creation of class hierarchies, allowing you to model real-world relationships and hierarchies in your code.
public class Inheritance extends Parent{
    @Override
    void doSomething() {

    }
}
