package com.ionn;

import java.util.Random;

public class Robot implements Runnable {
    private String name;
    Exploration explore ;
    private int extractedTokens;
    private volatile boolean running = true;
    private volatile boolean paused = false;
    private final Object pauseLock = new Object();

    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
    }

    public void run() {
        while (running) {
            synchronized (pauseLock) {
                if(paused){
                    try {
                        System.out.println("Pausing robot: " + name);
                        pauseLock.wait();
                        System.out.println("Starting robot: " + name);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Random random = new Random();
            int row = random.nextInt(0,explore.getN());
            int col = random.nextInt(0,explore.getN());
            synchronized (explore){
                explore.getMap().visit(row, col, this);
            }
        }
        System.out.println("Finished exploring: " + getName() + ", extracted " + extractedTokens + " tokens");
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public String getName() {
        return name;
    }

    public void pause(){
        paused = true;
    }

    public void resume(){
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll(); // Unblocks thread
        }
    }

    public boolean isRunning() {
        return running;
    }

    public int getExtractedTokens() {
        return extractedTokens;
    }

    public void addExtractedTokens(int extractedTokens) {
        this.extractedTokens = this.extractedTokens + extractedTokens;
    }
}

