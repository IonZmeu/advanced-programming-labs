package org.ionn;

import java.io.*;
import java.util.Scanner;

import static org.ionn.SimpleClient.PLAYER_ID;

public class WriteThread extends Thread {
    private final OutputStream outputStream;
    public WriteThread(OutputStream outputStream) {
        this.outputStream = outputStream;

    }

    @Override
    public void run() {
        PrintWriter out = new PrintWriter(outputStream,true);
        Scanner scanner = new Scanner(System.in);
        out.println(PLAYER_ID);
        while (true){
            String request = scanner.nextLine();
            if (request.equals("1")){//Create game
                out.println("Create game");
            }
            if (request.equals("2")){//Join game
                out.println("Join game");
            }
            if (request.matches("C.*")){
                out.println(request);
            }else{
                out.println(request);
            }
        }
    }
}
