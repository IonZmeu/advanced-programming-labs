package com.ionn.advancedprogramming.lab2;

import java.util.ArrayList;
import java.util.List;

public class MyMap {
    private final List<Location> locations = new ArrayList<>();
    private final List<Road> roads = new ArrayList<>();

    public void addLocation(Location location) {
        for (Location l : this.locations){
            if (l.equals(location)){
                System.out.println("This location already exists");
                return ;
            }
        }
        this.locations.add(location);
    }

    public void addRoad(Road road) {
        for (Road l : this.roads){
            if (l.equals(road)){
                System.out.println("This location already exists");
                return ;
            }
        }
        this.roads.add(road);
    }


    public boolean isValid(){
        System.out.println(locations);
        return true;
    }

}
