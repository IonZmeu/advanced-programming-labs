package org.ionn;

import lombok.Data;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.ionn.SimpleClient.PLAYER_ID;

@Data
public class WriteThread extends Thread {
    private final OutputStream outputStream;
    private boolean running = true;
    public WriteThread(OutputStream outputStream) {
        this.outputStream = outputStream;

    }

    @Override
    public void run() {
        PrintWriter out = new PrintWriter(outputStream,true);
        Scanner scanner = new Scanner(System.in);
        out.println(PLAYER_ID);
        while (running){
            String request = scanner.nextLine();
            if (request.equals("1")){//Create game
                out.println("Create game");
            }
            if (request.equals("2")){//Join game
                out.println("Join game");
            }
            if (request.matches("C.*")){
                out.println(request);
            }
            else{
                out.println(request);
            }
        }
    }
}
