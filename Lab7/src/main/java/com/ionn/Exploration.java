package com.ionn;


import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final Object lock = new Object();
    private int n = 5;
    public final SharedMemory mem = new SharedMemory(n);
    private final ExplorationMap map = new ExplorationMap(n);
    private final List<Robot> robots = new ArrayList<>();
    private final Timekeeper timekeeper = new Timekeeper();

    private static Exploration explore = new Exploration();


    public void start() {
        List<Thread> threadList = new ArrayList<>();
        for (Robot robot : robots) {
            Thread thread = new Thread(robot);
            threadList.add(thread);
            thread.start();
            System.out.println("robot " + robot.getName() + " started");
        }
        StartTimekeeper(threadList);
        StartCommandsManager(threadList);

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static void main(String args[]) {
        explore.robots.add(new Robot("Wall-E",explore));
        explore.robots.add(new Robot("R2D2",explore));
        explore.robots.add(new Robot("Optimus Prime",explore));

        explore.start();
    }

    public ExplorationMap getMap() {
        return map;
    }

    public int getN() {
        return n;
    }

    private void StartTimekeeper(List<Thread> threadList){
        timekeeper.setRobotList(robots);
        Thread thread = new Thread(timekeeper);
        threadList.add(thread);
        thread.start();
    }

    private void StartCommandsManager(List<Thread> threadList){
        CommandManager commandManager = new CommandManager(robots);
        commandManager.setExplore(explore);
        Thread thread = new Thread(commandManager);
        threadList.add(thread);
        thread.start();
    }
}