package com.ionn;

import java.util.HashMap;
import java.util.Map;

public class Person implements Node,Comparable<Person>{
    protected String name;
    private String birthDate;
    private Map<Node, String> relationships = new HashMap<>();

    public int getConnections(){
        return relationships.size();
    }
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +

                '}';
    }
}
