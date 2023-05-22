package org.ionn;

import lombok.Data;

public class Person {
    public String name;
    private int age;

    public void sayA (){
        System.out.println("A");
    }

    private void sayB (){
        System.out.println("B");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
