package org.ionn;

import lombok.Data;
import org.ionn.game.Game;
import org.ionn.game.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Data
public class SimpleServer {

    final static List<Player> playerList = new ArrayList<>();
    final static List<Game> gameList = new ArrayList<>();
    final Object lockObject = new Object();

    public static final int PORT = 8100;
    private int nrOfConnections = 0;
    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                    System.out.println("Waiting for connection ...");
                Socket socket = serverSocket.accept();
                synchronized (lockObject) {
                    String playerId = readPlayerId(socket.getInputStream());
                    Player player = new Player(playerId,socket);
                    playerList.add(player);
                    new ClientThread(player).start();
                }
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
    }

    private String readPlayerId(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        return in.readLine();
    }

}
