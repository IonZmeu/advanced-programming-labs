package org.ionn.game;

import lombok.Data;

@Data
public class Game {
    private String gameName;
    private Player player1;
    private Player player2;
    private Board gameBoard;
}
