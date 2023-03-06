package com.ionn;

import java.util.HashMap;
import java.util.Map;

public class Person implements Node,Comparable<Person>{
    private String name;
    private Map<Node, String> relationships = new HashMap<>();
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }
}
