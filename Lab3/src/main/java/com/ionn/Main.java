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
        Company company1 = new Company();
        company1.setName("Microsoft");
        Company company2 = new Company();
        company2.setName("Apple");

        person1.addRelationship(company1,"boss");

        Network network = new Network();
        network.addNode(person1);

    }
}