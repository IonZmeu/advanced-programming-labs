package com.ionn;

import java.util.ArrayList;
import java.util.List;
public class Location {
    private Cities city;
    private Airports airport;
    private GasStations gasStation;
    private final List<Road> roads = new ArrayList<>();
    private String name;
    private double x;
    private double y;

        public void addRoad(Road road) {
        for (Road l : this.roads){
            if (l.equals(road)){
                System.out.println("This location already exists");
                return ;
            }
        }
        this.roads.add(road);
    }

    public List<Road> getRoads() {
        return roads;
    }

    @Override
    public boolean equals(Object obj) {
        Location loc = (Location) obj;
        if (this.x == loc.x && this.y == loc.y && this.name == loc.name){return true;}else{return false;}
    }


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Airports getAirport() {
        return airport;
    }

    public void setAirport(Airports airport) {
        this.airport = airport;
    }

    public GasStations getGasStation() {
        return gasStation;
    }

    public void setGasStation(GasStations gasStation) {
        this.gasStation = gasStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}

