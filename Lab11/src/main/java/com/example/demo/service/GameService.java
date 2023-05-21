package com.example.demo.service;

import com.example.demo.data.Game;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class GameService {
    private final List<Game> gameList;
    ObjectMapper objectMapper = new ObjectMapper();

    public GameService() {
        gameList = new ArrayList<>();
    }

    public Game getById(int id) {
        return gameList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public int createNewGameFromObject(Game game) {
        int id = 1 + gameList.size();
        game.setId(id);
        gameList.add(game);
        return id;
    }

    public ResponseEntity<String> modifyGame(Game updatedGame) {
        Game game = getById(updatedGame.getId());
        if (game == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
        }
        game = updatedGame;
        return new ResponseEntity<>(
                "Player updated successsfully", HttpStatus.OK);
    }


    public int checkWinnerPlayer(Game game, int playerNumber) throws JsonProcessingException {
        int[][] boardField = objectMapper.readValue(game.getBoardArray(),int[][].class);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= 15 - 5; j++) {
                if (boardField[i][j] != 0 && boardField[i][j] == playerNumber &&
                        boardField[i][j] == boardField[i][j + 1] &&
                        boardField[i][j] == boardField[i][j + 2] &&
                        boardField[i][j] == boardField[i][j + 3] &&
                        boardField[i][j] == boardField[i][j + 4]) {
                    return playerNumber;
                }
            }
        }

        // Check columns
        for (int i = 0; i <= 15 - 5; i++) {
            for (int j = 0; j < 15; j++) {
                if (boardField[i][j] != 0 && boardField[i][j] == playerNumber &&
                        boardField[i][j] == boardField[i + 1][j] &&
                        boardField[i][j] == boardField[i + 2][j] &&
                        boardField[i][j] == boardField[i + 3][j] &&
                        boardField[i][j] == boardField[i + 4][j]) {
                    return playerNumber;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i <= 15 - 5; i++) {
            for (int j = 0; j <= 15 - 5; j++) {
                if (boardField[i][j] != 0 && boardField[i][j] == playerNumber &&
                        boardField[i][j] == boardField[i + 1][j + 1] &&
                        boardField[i][j] == boardField[i + 2][j + 2] &&
                        boardField[i][j] == boardField[i + 3][j + 3] &&
                        boardField[i][j] == boardField[i + 4][j + 4]) {
                    return playerNumber;
                }
            }
        }

        // Check reverse diagonals
        for (int i = 4; i < 15; i++) {
            for (int j = 0; j <= 15 - 5; j++) {
                if (boardField[i][j] != 0 && boardField[i][j] == playerNumber &&
                        boardField[i][j] == boardField[i - 1][j + 1] &&
                        boardField[i][j] == boardField[i - 2][j + 2] &&
                        boardField[i][j] == boardField[i - 3][j + 3] &&
                        boardField[i][j] == boardField[i - 4][j + 4]) {
                    return playerNumber;
                }
            }
        }

        return 0;
    }

    public String printCurrentBoard(Game game) throws JsonProcessingException {
        String s = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                s = s + objectMapper.readValue(game.getBoardArray(), int[][].class)[i][j];
                s = s + " ";
            }
            s = s + "\n";
        }
        return s;
    }
}
