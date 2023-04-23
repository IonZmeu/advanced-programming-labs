package com.ionn;


public class Robot implements Runnable {
    private int currentPositionX = 0;
    private int getCurrentPositionY = 0;
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
                        Thread.currentThread().interrupt();
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (explore){
                explore.getMap().visit(this);
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

    public int getCurrentPositionX() {
        return currentPositionX;
    }

    public void setCurrentPositionX(int currentPositionX) {
        this.currentPositionX = currentPositionX;
    }

    public int getGetCurrentPositionY() {
        return getCurrentPositionY;
    }

    public void setGetCurrentPositionY(int getCurrentPositionY) {
        this.getCurrentPositionY = getCurrentPositionY;
    }
}

