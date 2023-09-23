package com.neol.java.strings;

import org.junit.jupiter.api.Assertions;

public class TestString {
    public static void main(String[] args) {
        String a = "holahola";
        String b = "holahola";
        System.out.println(a == b);
        // a , b are references that point to the same memory address in heap
        Assertions.assertSame(a, b);

        String c = new String("holahola");
        System.out.println(a == c);
        Assertions.assertNotSame(a, c);

        // Pass the value to String Pool in Heap
        String d = c.intern();
        System.out.println(a == d);
        Assertions.assertSame(a, d);

    }
}
