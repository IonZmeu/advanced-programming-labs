package com.ionn;

public class Cities {
    String name;
    int population;
    public boolean equals(Object obj) {
        Cities city = (Cities) obj;
        if (this.population == city.population && this.name == city.name){return true;}else{return false;}
    }
}
