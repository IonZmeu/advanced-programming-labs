package org.ionn.game;

import lombok.Data;


@Data
public class Board {
    private int[][] board;
    public Board() {
        board = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++){
                board[i][j] = 0;
            }
        }
    }

    public void playerOneMove (int i, int j){
        board[i][j] = 1;
        checkWinner(1);
    }

    public void playerTwoMove (int i, int j){
        board[i][j] = 2;
        checkWinner(2);
    }

    public int checkWinner (int PlayerToCheck){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= 15 - 5; j++) {
                if (board[i][j] != 0 && board[i][j] == PlayerToCheck &&
                        board[i][j] == board[i][j + 1] &&
                        board[i][j] == board[i][j + 2] &&
                        board[i][j] == board[i][j + 3] &&
                        board[i][j] == board[i][j + 4]) {
                    return PlayerToCheck;
                }
            }
        }

        // Check columns
        for (int i = 0; i <= 15 - 5; i++) {
            for (int j = 0; j < 15; j++) {
                if (board[i][j] != 0 && board[i][j] == PlayerToCheck &&
                        board[i][j] == board[i + 1][j] &&
                        board[i][j] == board[i + 2][j] &&
                        board[i][j] == board[i + 3][j] &&
                        board[i][j] == board[i + 4][j]) {
                    return PlayerToCheck;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i <= 15 - 5; i++) {
            for (int j = 0; j <= 15 - 5; j++) {
                if (board[i][j] != 0 && board[i][j] == PlayerToCheck &&
                        board[i][j] == board[i + 1][j + 1] &&
                        board[i][j] == board[i + 2][j + 2] &&
                        board[i][j] == board[i + 3][j + 3] &&
                        board[i][j] == board[i + 4][j + 4]) {
                    return PlayerToCheck;
                }
            }
        }

        // Check reverse diagonals
        for (int i = 4; i < 15; i++) {
            for (int j = 0; j <= 15 - 5; j++) {
                if (board[i][j] != 0 && board[i][j] == PlayerToCheck &&
                        board[i][j] == board[i - 1][j + 1] &&
                        board[i][j] == board[i - 2][j + 2] &&
                        board[i][j] == board[i - 3][j + 3] &&
                        board[i][j] == board[i - 4][j + 4]) {
                    return PlayerToCheck;
                }
            }
        }

        return 0;
    }

    public String printBoard(){
        String s = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++){
                s = s + board[i][j];
                s = s + " ";
            }
            s = s + "\n";
        }
        return s;
    }
}
