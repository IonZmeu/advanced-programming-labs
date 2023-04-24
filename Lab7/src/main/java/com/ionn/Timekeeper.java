package com.ionn;

import java.time.Instant;
import java.util.List;

public class Timekeeper implements Runnable {
    private boolean running = true;
    private long startTime;
    private long timeLimit = 5;

    private List<Robot> robotList;


    public Timekeeper(long startTime, List<Robot> robotList) {
        this.startTime = startTime;
        this.robotList = robotList;
    }

    @Override
    public void run() {
        while (running) {
            var endTime = Instant.now().toEpochMilli();
            var explorationTime = endTime - startTime;
            explorationTime = explorationTime / 1000;
            if (explorationTime > timeLimit) {
                System.out.println("Time limit exceeded");
                robotList.forEach(robot -> robot.setRunning(false));
                break;
            }
            if (!robotList.get(0).isRunning()) {
                System.out.println("exploration finished in " + explorationTime + "s");
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setRobotList(List<Robot> robotList) {
        this.robotList = robotList;
    }

}
