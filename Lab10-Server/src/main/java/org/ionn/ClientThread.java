package org.ionn;

import org.ionn.game.Board;
import org.ionn.game.Game;
import org.ionn.game.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ClientThread extends Thread {
    private final Player player;
    private Game game;
    private int lastMove = 0;
    private boolean stopCommand = false;

    public ClientThread(Player player) {
        this.player = player;
    }

    public void run() {
        System.out.println("Player count: " + SimpleServer.playerList.size());
        System.out.println("New player has joined: " + player.getPlayerId());

        for (Player player : SimpleServer.playerList) {
            if (!player.getPlayerId().equals(this.player.getPlayerId())) {
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

        while (true) {
            try {
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(player.getSocket().getInputStream()));
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(player.getSocket().getOutputStream());
                if (request.equals("Create game")) {
                    game = new Game();
                    game.setGameBoard(new Board());
                    game.setGameName("custom game");
                    player.setPlayerNumber(1);
                    game.setPlayer1(player);
                    SimpleServer.gameList.add(game);
                    String raspuns = "Game was created, you are player 1, waiting for another player ";
                    out.println(raspuns);
                    out.flush();
                }

                if (request.equals("Join game")) {
                    if (SimpleServer.gameList.isEmpty()) {
                        String raspuns = "No available games";
                        out.println(raspuns);
                        out.flush();
                    } else {
                        this.game = SimpleServer.gameList.get(0);
                        player.setPlayerNumber(2);
                        game.setPlayer2(player);
                        String raspuns = "You have joined a game with the name " + game.getGameName() + ", you are player 2";
                        out.println(raspuns);
                        out.flush();

                        PrintWriter out2 = new PrintWriter(game.getPlayer1().getSocket().getOutputStream());
                        out2.println("The game has started, wait for your opponent to submit his move");
                        out2.flush();
                        out2 = new PrintWriter(game.getPlayer2().getSocket().getOutputStream());
                        out2.println("The game has started, submit your move");
                        out2.flush();
                        out2.println("3.Submit coordinates in the form : С:x,y");
                        out2.flush();
                    }
                }

                if (request.matches("C.*")) {
                    String[] xyTogether = request.split(":",2);
                    String[] xy = xyTogether[1].split(",",2);
                    int coordinateX = Integer.parseInt(xy[0]);
                    int coordinateY = Integer.parseInt(xy[1]);
                    if (player.getPlayerNumber() == 1){
                        game.getGameBoard().playerOneMove(coordinateX,coordinateY);
                        PrintWriter out2 = new PrintWriter(game.getPlayer2().getSocket().getOutputStream());
                        out2.println("The other player moved x:" + coordinateX + " y:" + coordinateY);
                        out2.flush();
                        out2 = new PrintWriter(game.getPlayer2().getSocket().getOutputStream());
                        out2.println("3.Submit coordinates in the form : С:x,y");
                        out2.flush();
                    }

                    if (player.getPlayerNumber() == 2){
                        game.getGameBoard().playerTwoMove(coordinateX,coordinateY);
                        PrintWriter out2 = new PrintWriter(game.getPlayer1().getSocket().getOutputStream());
                        out2.println("The other player moved x:" + coordinateX + " y:" + coordinateY);
                        out2.flush();
                        out2 = new PrintWriter(game.getPlayer1().getSocket().getOutputStream());
                        out2.println("3.Submit coordinates in the form : С:x,y");
                        out2.flush();
                    }
                }

            } catch (IOException e) {
                System.err.println("Communication error... " + e);
            }
        }

    }

}
