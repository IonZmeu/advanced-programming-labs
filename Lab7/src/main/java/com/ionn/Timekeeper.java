package com.ionn;

import java.util.ArrayList;
import java.util.List;

public class Timekeeper implements Runnable{
    private boolean running = true;

    private List<Robot> robotList = new ArrayList<>();

    @Override
    public void run() {
        while (running) {
            // System.out.println("working");
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setRobotList(List<Robot> robotList) {
        this.robotList = robotList;
    }

}
