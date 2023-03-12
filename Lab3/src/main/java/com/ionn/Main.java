package com.ionn;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Programmer person1 = new Programmer();
        person1.setName("John");
        person1.setBirthDate("10 july");
        person1.setBackEnd(true);
        Designer person2 = new Designer();
        person2.setName("Ana");
        person2.setBirthDate("5 october");
        person2.setYearsOfExperience(7);
        Programmer person3 = new Programmer();
        person3.setName("Bella");
        person3.setBirthDate("3 august");
        person3.setBackEnd(false);
        Company company1 = new Company();
        company1.setName("Microsoft");
        Company company2 = new Company();
        company2.setName("Apple");
        Programmer person4 = new Programmer();
        Programmer person5 = new Programmer();
        Programmer person6 = new Programmer();
        person4.setName("John");
        person4.setBirthDate("10 july");
        person4.setBackEnd(true);
        person5.setName("John");
        person5.setBirthDate("10 july");
        person5.setBackEnd(true);
        person6.setName("John");
        person6.setBirthDate("10 july");
        person6.setBackEnd(true);



        person1.addRelationship(company1,"boss");
        person2.addRelationship(company1,"boss");
        person3.addRelationship(company2,"boss");
        person1.addRelationship(company2,"another company");
        person2.addRelationship(company2,"another company");
        person3.addRelationship(company1,"another company");
        person1.addRelationship(person2,"coworker");
        person2.addRelationship(person1,"coworker");
        person1.addRelationship(person3,"friend");
        person2.addRelationship(person3,"friend");
        person3.addRelationship(person1,"friend");
        person3.addRelationship(person2,"friend");
        company1.addRelationship(person1,"employee");
        company1.addRelationship(person2,"employee");
        company1.addRelationship(person3,"concurrent company employee");
        company2.addRelationship(person1,"concurrent company employee");
        company2.addRelationship(person2,"concurrent company employee");
        company2.addRelationship(person4,"employee");
        company2.addRelationship(person5,"employee2");
        company2.addRelationship(person6,"employee3");

        List<Company> companyList = new ArrayList<>();
        companyList.add(company1);
        companyList.add(company2);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        Network network = new Network();
        network.setPersonList(personList);
        network.setCompanyList(companyList);

        network.print();

    }
}