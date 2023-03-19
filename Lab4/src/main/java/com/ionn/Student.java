package com.ionn;

import javax.xml.stream.events.StartDocument;
import java.util.List;

public class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
