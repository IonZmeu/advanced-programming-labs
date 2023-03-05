package com.ionn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location location1 = new Location();

        Road road1 = new Road();
        road1.setLength(100.0);
        road1.setSpeedLimit(50);
        road1.setName("road1");
        //System.out.println(road1);

        Road road2 = new Road();
        road1.setLength(150.0);
        road1.setSpeedLimit(50);
        road1.setName("road2");
        //System.out.println(road2);


        location1.setName("Iasi1");
        location1.setX(200);
        location1.setY(300);
        location1.addRoad(road1);
        //System.out.println(location1);

        Location location2 = new Location();
        location2.setName("Iasi2");
        location2.setX(200);
        location2.setY(450);
        location2.addRoad(road1);

        MyMap myMap = new MyMap();
        myMap.addLocation(location1);
        myMap.addLocation(location2);
        System.out.println("Is valid : " + myMap.isValid());
        System.out.println();

    }
}
