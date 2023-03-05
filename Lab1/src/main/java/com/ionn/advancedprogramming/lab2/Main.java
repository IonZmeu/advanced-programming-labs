package com.ionn.advancedprogramming.lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location location1 = new Location();

        location1.setName("Iasi");
        location1.setX(123);
        location1.setY(4234);
        System.out.println(location1);

        Road road1 = new Road();
        road1.setLength(100);
        road1.setSpeedLimit(50);
        System.out.println(road1);

        Location location2 = new Location();
        location2.setName("Iasi");
        location2.setX(123);
        location2.setY(4234);

        System.out.println(location1.equals(location2));
        MyMap myMap = new MyMap();
        myMap.addLocation(location1);
        myMap.addRoad(road1);
        System.out.println();
    }
}
