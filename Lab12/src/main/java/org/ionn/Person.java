package org.ionn;

import org.junit.Test;

public class Person {
    public String name;
    private int age;

    @Test
    public static void sayA (){
        System.out.println("A");
    }

    private static void sayB (){
        System.out.println("B");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
