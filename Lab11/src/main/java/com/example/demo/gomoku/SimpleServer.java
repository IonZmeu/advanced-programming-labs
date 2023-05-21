package com.example.demo.gomoku;

import com.example.demo.controller.GameController;
import com.example.demo.controller.PlayerController;
import com.example.demo.controller.ProductController;
import com.example.demo.data.Player;
import lombok.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;



@Data
public class SimpleServer {
    private final GameController gameController = new GameController();
    private final PlayerController playerController = new PlayerController();
    private final ProductController productController = new ProductController();
    final Object lockObject = new Object();

    public static final int PORT = 8100;
    private int nrOfConnections = 0;
    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        productController.createProduct("ceva");
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                    System.out.println("Waiting for connection ...");
                Socket socket = serverSocket.accept();
                synchronized (lockObject) {
                    int playerId = readPlayerId(socket.getInputStream());
                    Player player = new Player(playerId,0,socket,null);
                    playerController.createPlayer(player);
                    new ClientThread(player, playerController, gameController).start();
                }
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    private int readPlayerId(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        return in.readLine().hashCode();
    }

}
