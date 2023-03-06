package com.ionn;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.setName("John");
        Person person2 = new Person();
        person2.setName("Ana");
        Person person3 = new Person();
        person3.setName("Bella");
        Company company = new Company();
        company.setName("Microsoft");
        List<Person> personl = new ArrayList<>();
        personl.add(person1);
        personl.add(person2);
        personl.add(person3);
        Collections.sort(personl);
        for (Person n : personl) {
            System.out.println(n.getName());
        }
    }
}