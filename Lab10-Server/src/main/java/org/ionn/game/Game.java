package org.ionn.game;

import lombok.Data;

@Data
public class Game {
    private long timePlayer2;
    private long timePlayer1;
    private String gameName;
    private Player player1;
    private Player player2;
    private Board gameBoard;
}
