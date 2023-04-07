package com.ionn;

import java.util.Random;

public class Robot implements Runnable {
    private String name;
    private boolean running = true;
    Exploration explore ;
    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
    }

    public void run() {
        while (running) {
            Random random = new Random();
            int row = random.nextInt(0,explore.getN());
            int col = random.nextInt(0,explore.getN());
            synchronized (explore){
                explore.getMap().visit(row, col, this);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public String getName() {
        return name;
    }
}
