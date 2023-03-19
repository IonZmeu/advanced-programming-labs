package com.ionn;
//Zmeu Ion E4 compulsory + homework
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //faker object from the library added in maven that will generate differentn names for the studetnts and projects
        Faker faker = new Faker();
        //Creating array of projects
        var arrayOfProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project(faker.app().name() + i) )
                .toArray(Project[]::new);


        //creating an array of students
        var arrayOfStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student(faker.name().firstName() + i) )
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
        System.out.println("*** List of students : " + listOfStudents);
        System.out.println("*** TreeSet of projects : " + TreeSetOfProjects);

        //creating a map that contains lists with different projects admissible for each student
        Map<Student, List<Project>> map = new HashMap<>();

        map.put(arrayOfStudents[0],List.of(arrayOfProjects[0],arrayOfProjects[1],arrayOfProjects[2]));
        map.put(arrayOfStudents[1],List.of(arrayOfProjects[0],arrayOfProjects[1]));
        map.put(arrayOfStudents[2],List.of(arrayOfProjects[0]));
        //setting up the matching object
        Matching matching = new Matching();
        matching.setStudentList(listOfStudents);
        matching.setProjectList(TreeSetOfProjects);
        matching.setPrefMap(map);
        //display all the students that have a number of preferences lower than the average number of preferences.
        matching.lowerPreferences();
        //greedy algorithm that associates each student a project
        matching.maximumCardinalityMatching();

    }
}