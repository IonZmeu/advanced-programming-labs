package com.ionn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog() {}

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public void add(Document doc) {
        docs.add(doc);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }
}
