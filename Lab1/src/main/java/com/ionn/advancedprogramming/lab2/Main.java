package com.ionn.advancedprogramming.lab2;

public class Main {
    public static void main(String[] args) {
    Location location = new Location();

    location.setName("Iasi");
    location.setX(123);
    location.setY(4234);
    System.out.println(location.toString());

    Road road = new Road();
    road.setLength(100);
    road.setSpeedLimit(50);
    System.out.println(road.toString());
    }
}
