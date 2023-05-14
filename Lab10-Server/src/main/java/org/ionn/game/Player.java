package org.ionn.game;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.Socket;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Player {
    private int playerNumber;
    private String playerId;
    private Socket socket;

    public Player(String playerId, Socket socket) {
        this.playerId = playerId;
        this.socket = socket;
    }
}
