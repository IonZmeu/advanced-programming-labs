package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.net.Socket;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int id;
    private int playerNumber;
    private Socket socket;
    private String name;

    public Player(int playerId, Socket socket) {
        this.id = playerId;
        this.socket = socket;
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
