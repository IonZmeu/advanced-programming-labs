package org.ionn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ClientThread extends Thread {
    private final Player player;
    private boolean stopCommand = false;

    public ClientThread(Player player) {
        this.player = player;
    }

    public void run() {
        System.out.println("Player count: " + SimpleServer.playerList.size());
        System.out.println("New player has joined: " + player.getPlayerId());

        for (Player player : SimpleServer.playerList) {
            if (!player.getPlayerId().equals(this.player.getPlayerId())){
                PrintWriter out = null;
                try {
                    out = new PrintWriter(player.getSocket().getOutputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String raspuns = "New player has joined the server";
                out.println(raspuns);
                out.flush();
            }
        }

        while (true){
            try {
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(player.getSocket().getInputStream()));
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(player.getSocket().getOutputStream());
                String raspuns = "Hello player ! you wrote : " + request;
                out.println(raspuns);
                out.flush();
            } catch (IOException e) {
                System.err.println("Communication error... " + e);
            }
        }

    }

}
