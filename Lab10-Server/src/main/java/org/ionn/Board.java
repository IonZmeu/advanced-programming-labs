package org.ionn;

import lombok.Data;


@Data
public class Board {
    private int[][] Board;

    public Board() {
        Board = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++){
                Board[i][j] = 0;
            }
        }
    }

    public void playerOneMove (int i, int j){
        Board[i][j] = 1;
    }

    public void playerTwoMove (int i, int j){
        Board[i][j] = 2;
    }

    public void checkWinner (){

    }
}
