package com.ionn;
public class Road {

    private String name;
    private double length;
    private int speedLimit;

    public boolean different(Object obj){
        Road road = (Road) obj;
        if (this.name.equals(road.name)){
            return false;
        }
        return true;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }


    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    enum type{
        HIGHWAYS,
        EXPRESS,
        COUNTRY
    }

}

