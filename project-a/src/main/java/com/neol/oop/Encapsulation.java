package com.neol.oop;

// Encapsulation is the concept of bundling data (attributes) and the methods (functions) that operate on that data into a single unit known as a class

// Data Hiding: hides the internal state of an object from external access, which prevents accidental modification and enforces controlled access through methods.
// Modularity: promotes modular design by breaking down a system into smaller, self-contained classes, which can be developed, tested, and maintained independently.
// Maintenance: allows for changes to the internal implementation of a class without affecting other parts of the program that use the class.
public class Encapsulation {
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
