package com.ionn;

import javax.xml.stream.events.StartDocument;
import java.util.List;

public class Student {
    String name;
    List<Project> acceptableProjects;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", acceptableProjects=" + acceptableProjects +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
