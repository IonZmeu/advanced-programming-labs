package org.ionn;

import org.junit.Test;

public class Person {
    public String name;
    private int age;

    @Test
    public static void sayA() {
        System.out.println("public Test Method With no arguments ");
    }

    private static void sayB() {
        System.out.println("private non Test Method With no arguments ");
    }

    @Test
    public static void sayC(int i) {
        System.out.println("public Test Method With arguments int ");
    }
    @Test
    private static void sayD() {
        System.out.println("private Test Method With no arguments ");
    }

    @Test
    private static void sayE(int i,String j) {
        System.out.println("private Test Method With arguments int and String ");
    }

    private static void sayF(int i) {
        System.out.println("private non Test Method With arguments int ");
    }

    @Test
    public static void sayG(int i,String j) {
        System.out.println("public Test Method With arguments int and String ");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
