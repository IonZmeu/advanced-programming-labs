package com.ionn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Road road1 = new Road("road1",100.0,50);
        Road road2 = new Road("road2",150.0,70);
        Road road3 = new Road("road3",200.0,30);
        Road road4 = new Road("road4",175.0,80);
        //Road road5 = new Road("road5",70.0,50);
        //Road road6 = new Road("road6",50.0,70);

        Location location1 = new Location("Iasi1",200,300);
        location1.addOutRoad(road1);
        location1.addOutRoad(road3);
        Location location2 = new Location("Iasi2",200,450);
        location2.addInRoad(road1);
        location2.addOutRoad(road2);
        Location location3 = new Location("Iasi3",210,323);
        location3.addInRoad(road2);
        location3.addInRoad(road3);
        Location location4 = new Location("Iasi4",220,330);
        location4.addInRoad(road4);
        location4.addOutRoad(road2);



        MyMap myMap = new MyMap();
        myMap.addLocation(location1);
        myMap.addLocation(location2);
        myMap.addLocation(location3);
        myMap.addLocation(location4);

        System.out.println("incepe");
        System.out.println();
        //System.out.println(myMap.toOther(location1,location2));
        System.out.println("Is valid : " + myMap.isValid());
    }
}

