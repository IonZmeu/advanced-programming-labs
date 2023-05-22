package com.example.demo.gomoku;

import com.example.demo.controller.GameController;
import com.example.demo.controller.PlayerController;
import com.example.demo.data.Game;
import com.example.demo.data.Player;
import com.example.demo.serializer.SocketSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    ObjectMapper objectMapper = new ObjectMapper();
    private final PlayerController playerController;
    private final GameController gameController;
    Game game = new Game();
    private final int playerId;
    private  int gameId;
    private String gameName;
    public ClientThread(Player player, PlayerController playerController, GameController gameController) {
        this.playerId = player.getId();
        this.playerController = playerController;
        this.gameController = gameController;
    }

    public void run() {
        System.out.println("Player count: " + playerController.getPlayers().size());
        System.out.println("New player has joined: " + playerController.getPlayer(playerId));

        for (Player player : playerController.getPlayers()) {
            if (player.getId() != playerId) {
                PrintWriter out = null;
                try {
                    out = new PrintWriter(objectMapper.readValue(player.getSocket(), Socket.class).getOutputStream());
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
                        new InputStreamReader(objectMapper.readValue(playerController.getPlayer(playerId).getSocket(), Socket.class).getInputStream()));
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(objectMapper.readValue(playerController.getPlayer(playerId).getSocket(), Socket.class).getOutputStream());
                if (request.equals("Create game")) {
                    game = new Game();
                    game.setBoardArray(objectMapper.writeValueAsString(new int[15][15]));
                    game.setName("custom game");
                    game.getPlayers().add(0,playerController.getPlayer(playerId));
                    gameController.createGame(game);

                    gameId = 0;////////////

                    playerController.getPlayer(playerId).setPlayerNumber(1);
                    playerController.updatePlayerNumber(playerController.getPlayer(playerId),1);
                    String raspuns = "Game was created, you are player 1, waiting for another player ";
                    out.println(raspuns);
                    out.flush();
                }

                if (request.equals("Join game")) {
                    if (gameController.getGames().isEmpty()) {
                        String raspuns = "No available games";
                        out.println(raspuns);
                        out.flush();
                    } else {
                        game = gameController.getGames().get(0);
                        gameId = game.getId();
                        playerController.updatePlayerNumber(playerController.getPlayer(playerId),2);

                        game.getPlayers().add(1,playerController.getPlayer(playerId));
                        gameController.updateGame(game);

                        String raspuns = "You have joined a game with the name " + game.getName() + ", you are player 2";
                        out.println(raspuns);
                        out.flush();

                        PrintWriter out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(0).getSocket(), Socket.class).getOutputStream());
                        out2.println("The game has started, wait for your opponent to submit his move");
                        out2.flush();
                        out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(1).getSocket(), Socket.class).getOutputStream());
                        out2.println("The game has started, submit your move");
                        out2.flush();
                        out2.println("3.Submit coordinates in the form : С:x,y");
                        out2.flush();
                    }
                }

                if (request.matches("C:.*")) {
                    String[] xyTogether = request.split(":",2);
                    String[] xy = xyTogether[1].split(",",2);
                    int coordinateX = Integer.parseInt(xy[0]);
                    int coordinateY = Integer.parseInt(xy[1]);
                    if (playerController.getPlayer(playerId).getPlayerNumber() == 1){

                        int board[][] = objectMapper.readValue(game.getBoardArray(), int[][].class);
                        board[coordinateX][coordinateY] = playerController.getPlayer(playerId).getPlayerNumber();
                        game.setBoardArray(objectMapper.writeValueAsString(board));
                        gameController.updateGame(game);

                        PrintWriter out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(1).getSocket(), Socket.class).getOutputStream());
                        out2.println("The other player moved x:" + coordinateX + " y:" + coordinateY);
                        out2.flush();

                        out2.println(gameController.printBoard(game));

                        out2.flush();
                        if (gameController.checkWinner(game,2) == 2){
                            out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(0).getSocket(), Socket.class).getOutputStream());
                            out2.println("You lost");
                            out2.flush();

                            out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(1).getSocket(), Socket.class).getOutputStream());
                            out2.println("You Won");
                            out2.flush();
                        }else {
                            out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(1).getSocket(), Socket.class).getOutputStream());
                            out2.println("3.Submit coordinates (from 0 to 14) in the form : С:x,y");
                            out2.flush();
                        }
                    }

                    if (playerController.getPlayer(playerId).getPlayerNumber() == 2){

                        int board[][] = objectMapper.readValue(game.getBoardArray(), int[][].class);
                        board[coordinateX][coordinateY] = playerController.getPlayer(playerId).getPlayerNumber();
                        game.setBoardArray(objectMapper.writeValueAsString(board));
                        gameController.updateGame(game);

                        PrintWriter out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(0).getSocket(), Socket.class).getOutputStream());
                        out2.println("The other player moved x:" + coordinateX + " y:" + coordinateY);
                        out2.flush();
                        out2.println(gameController.printBoard(game));
                        out2.flush();

                        if (gameController.checkWinner(game,1) == 1){
                            out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(1).getSocket(), Socket.class).getOutputStream());
                            out2.println("You lost");
                            out2.flush();
                            out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(0).getSocket(), Socket.class).getOutputStream());
                            out2.println("You Won");
                            out2.flush();
                        }else{
                            out2 = new PrintWriter(objectMapper.readValue(game.getPlayers().get(0).getSocket(), Socket.class).getOutputStream());
                            out2.println("3.Submit coordinates in the form : С:x,y");
                            out2.flush();
                        }
                    }
                }

            } catch (IOException e) {
                System.err.println("Communication error... " + e);
            }
        }

    }

}
