package com.ionn;

import java.util.HashMap;
import java.util.Map;

public class Company implements Node,Comparable<Company> {
    private String name;

    private Map<Node, String> relationships = new HashMap<>();

    public int getConnections(){
        return relationships.size();
    }
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }
    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", relationships=" + relationships +
                '}';
    }
    public void print(){
        System.out.println( "Company{" +
                "name='" + name + '\'' +
                ", relationships=" + relationships +
                '}');
    }
}
