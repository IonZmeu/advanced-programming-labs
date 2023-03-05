package com.ionn;

public class Location {
    private Cities city;
    private Airports airport;
    private GasStations gasStation;
    private Road road;
    private String name;
    private float x;
    private float y;


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

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

//    enum type{
//        CITIES,
//        AIRPORTS,
//        GAS_STATIONS
//    }


}

