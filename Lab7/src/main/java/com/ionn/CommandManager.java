package com.ionn;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CommandManager implements Runnable {
    private List<Robot> robotList ;
    public CommandManager(List<Robot> robotList) {
        this.robotList = robotList;
    }

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        while (hasNextLine(scanner)) {
            String command = scanner.nextLine();
            if(command.equals("startALL")){
                System.out.println("starting all robots");
                startAllRobots();
            } else if (command.equals("pauseALL")) {
                System.out.println("stopping all robots");
                pauseAllRobots();
            } else if (command.contains("pause ")) {
                pauseRobot(parseRobotName(command,"pause "));
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
            robotList.forEach(Robot::resume);
    }

    private void pauseAllRobots() {
            robotList.forEach(Robot::pause);
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

    private boolean hasNextLine(Scanner sin)  {
        while (true) {
            try {
                if ((System.in.available() != 0)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return sin.hasNextLine();
    }
}
