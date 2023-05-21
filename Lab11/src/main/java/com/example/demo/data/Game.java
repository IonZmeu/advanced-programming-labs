package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private String name;
    private Player player1;
    private Player player2;
    private int[][] boardArray;
}
