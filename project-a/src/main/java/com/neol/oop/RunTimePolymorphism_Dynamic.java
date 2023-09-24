package com.neol.oop;

//  Polymorphism enables a single interface to represent different types of objects and provides the ability to
//  perform operations on objects without knowing their specific types at compile time.

// Flexibility: promotes code flexibility by allowing the same method or interface to work with different types of objects, making the code more adaptable to change.
// Extensibility: You can create new classes that implement existing interfaces, ensuring that they can be used
    // interchangeably with other objects implementing the same interface.
// Code Reduction: Polymorphism simplifies code by reducing the need for complex conditional statements based on object types.
class Father{
    public void print(){
        System.out.println("Im your father");
    }

}
// METHOD OVERRIDING
class Son extends Father {
    @Override
    public void print() {
        System.out.println("Im the son");

    }
}
// Because only at run time we know where is the actual method to run
public class RunTimePolymorphism_Dynamic {
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.print();
        son.print();

    }
}
