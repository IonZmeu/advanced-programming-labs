package com.ionn;

import java.util.HashMap;
import java.util.Map;

public class Designer extends Person {
    private int yearsOfExperience;
    private String name;
    private String birthDate;
    private Map<Node, String> relationships = new HashMap<>();

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

}
