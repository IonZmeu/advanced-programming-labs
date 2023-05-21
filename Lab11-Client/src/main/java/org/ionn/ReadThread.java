package org.ionn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadThread extends Thread {
    private boolean running = true;
    private WriteThread writeThread;
    private final InputStream inputStream;
    public ReadThread(InputStream inputStream) {
        this.inputStream = inputStream;

    }

    public ReadThread(WriteThread writeThread, InputStream inputStream) {
        this.writeThread = writeThread;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        while (running){
            try {
                String fromServer = in.readLine();

                if (fromServer.matches("You Lost") || fromServer.matches("You Won")){
                    System.out.println(fromServer);
                    writeThread.setRunning(false);
                    running = false;
                } else {
                    System.out.println(fromServer);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
