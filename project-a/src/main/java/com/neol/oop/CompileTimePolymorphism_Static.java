package com.neol.oop;

//  Polymorphism enables a single interface to represent different types of objects and provides the ability to
//  perform operations on objects without knowing their specific types at compile time.

// Flexibility: promotes code flexibility by allowing the same method or interface to work with different types of objects, making the code more adaptable to change.
// Extensibility: You can create new classes that implement existing interfaces, ensuring that they can be used
    // interchangeably with other objects implementing the same interface.
// Code Reduction: Polymorphism simplifies code by reducing the need for complex conditional statements based on object types.

// The methods name can be the same as long as the signatures changes
public class CompileTimePolymorphism_Static {
    public static void main(String[] args) {
        print(0, 0);
        print(0f, 0);
        print(0);
        print("0");

    }
    // OVERLOADING
    static void print(int a, int b){
        System.out.println("a,b");
    }
    // OVERLOADING
    static void print(float a, int b){
        System.out.println("a,b");
    }
//NAME DOES NOT MATTER, THE DATATYPE IS THE ISSUE
//    static void print(int b, int a){
//        System.out.println("a,b");
//    }
    // OVERLOADING
    static void print(int a){
        System.out.println("a");
    }
    // OVERLOADING
    static void print(String a){
        System.out.println("a");
    }
// COMPILE FAILS BECAUSE THE RETURN TYPE HAS TO BE THE SAME
//    static String print(String a){
//        System.out.println("a");
//    }
}
