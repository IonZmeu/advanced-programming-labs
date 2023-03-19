package com.ionn;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Creating array of projects
        var arrayOfProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);

        //creating lists with different projects
        List<Project> list0 = List.of(arrayOfProjects[0],arrayOfProjects[1],arrayOfProjects[2]);
        List<Project> list1 = List.of(arrayOfProjects[0],arrayOfProjects[1]);
        List<Project> list2 = List.of(arrayOfProjects[0]);

        //creating an array of students
        var arrayOfStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        LinkedList<Student> listOfStudents = new LinkedList<>();

        //creating a linked list of students
        listOfStudents.addAll(Arrays.asList(arrayOfStudents));

        //sorting the linked list of students using a lambda function
        Collections.sort(listOfStudents,
                ((u, v) -> u.getName().compareTo(v.getName())));

        TreeSet<Project> TreeSetOfProjects = new TreeSet<>();

        //creating a Tree Set of projects
        TreeSetOfProjects.addAll(Arrays.asList(arrayOfProjects));

        //printing the sorted linked list of students and a Tree Set of projects
        System.out.println(listOfStudents);
        System.out.println(TreeSetOfProjects);


    }
}