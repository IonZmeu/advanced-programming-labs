package com.ionn.advancedprogramming.lab2;

public class Road {
    private float length;
    private int speedLimit;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
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

    enum type{
        HIGHWAYS,
        EXPRESS,
        COUNTRY
    }

}
