package com.ionn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandManager implements Runnable {
    private List<Robot> robotList ;
    private Exploration explore = new Exploration();
    private  List<Robot> suspendedRobotList = new ArrayList<>();
    public CommandManager(List<Robot> robotList) {
        this.robotList = robotList;
    }

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if(command.equals("startALL")){
                System.out.println("starting all robots");
                startAllRobots();
            } else if (command.equals("pauseALL")) {
                System.out.println("stopping all robots");
                pauseAllRobots();
            } else if (command.contains("pause ")) {
                pauseRobot(parseRobotName(command,"stop "));
            } else if (command.contains("start ")) {
                startRobot(parseRobotName(command,"start "));
            } else {
                System.out.println("Invalid command!");
            }
        }
    }

    private static String parseRobotName(String command,String regex) {
        var array = command.split(regex);
        if(array.length == 2){
            return array[1];
        }
        return null;
    }

    private void startAllRobots(){
        synchronized (explore) {
            robotList.forEach(Robot::resume);
        }
    }

    private void pauseAllRobots() {
        synchronized (explore) {
            robotList.forEach(Robot::pause);
        }
    }

    private void startRobot(String robotName){
        robotList.stream()
                .filter(robot -> robot.getName().equals(robotName))
                .forEach(Robot::resume);
    }

    private void pauseRobot(String robotName) {
        robotList.stream()
                .filter(robot -> robot.getName().equals(robotName))
                .forEach(Robot::pause);
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }
}
