package com.ionn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {
    String id ;
    String name;
    private Map<String, Object> tags = new HashMap<>();

    private List<Document> docs = new ArrayList<>();

    public Document(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                ", docs=" + docs +
                '}';
    }
}
