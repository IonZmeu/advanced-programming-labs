package com.example.demo.controller;

import com.example.demo.data.Game;
import com.example.demo.data.Player;
import com.example.demo.service.GameService;
import com.example.demo.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService = new GameService();

    @GetMapping
    public List<Game> getGames() {
        return gameService.getGameList();
    }
    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") int id) {
        return gameService.getById(id);
    }
    @GetMapping("/board")
    public String printBoard(@RequestBody Game game) {
        return printBoard(game);
    }
    @GetMapping("/checkWinner")
    public int checkWinner(@RequestBody Game game,@RequestParam int playerId) {
        return gameService.checkWinnerPlayer(game,playerId);
    }

    @PostMapping
    public int createGame(@RequestBody Game game) {
        return gameService.createNewGameFromObject(game);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateGame(@RequestBody Game game) {
        return gameService.modifyGame(game);
    }

}
