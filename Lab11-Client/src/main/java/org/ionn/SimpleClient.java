package org.ionn;

import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class SimpleClient {
    public static final String PLAYER_ID = UUID.randomUUID().toString();

    public static void main(String[] args) throws IOException, InterruptedException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        Socket socket = new Socket(serverAddress, PORT);
        WriteThread writeThread = new WriteThread(socket.getOutputStream());
        ReadThread readThread = new ReadThread(writeThread,socket.getInputStream());
        writeThread.start();
        readThread.start();
        System.out.println("1.Create game");
        System.out.println("2.Join game");
        writeThread.join();
        readThread.join();
    }
}
