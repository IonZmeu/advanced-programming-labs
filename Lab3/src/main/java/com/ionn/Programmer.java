package com.ionn;

import java.util.HashMap;
import java.util.Map;

public class Programmer extends Person {
    private boolean backEnd;
    private String name;
    private String birthDate;
    private Map<Node, String> relationships = new HashMap<>();


    public boolean isBackEnd() {
        return backEnd;
    }

    public void setBackEnd(boolean backEnd) {
        this.backEnd = backEnd;
    }

}
