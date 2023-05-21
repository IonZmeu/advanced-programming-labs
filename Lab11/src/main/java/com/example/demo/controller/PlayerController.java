package com.example.demo.controller;

import com.example.demo.data.Player;
import com.example.demo.data.Product;
import com.example.demo.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService = new PlayerService();

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayerList();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return playerService.getById(id);
    }

    @PostMapping
    public int createPlayer(@RequestBody Player player) {
        return playerService.createNewPlayerFromObject(player);
    }

    @PutMapping("/number")
    public ResponseEntity<String> updatePlayerNumber(@RequestBody Player player, @RequestParam int playerNumber) {
        return playerService.modifyPlayerNumber(player, playerNumber);
    }

    @PutMapping("/name")
    public ResponseEntity<String> updatePlayerName(@RequestBody Player player, @RequestParam String name) {
        return playerService.modifyPlayerName(player, name);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePlayer(@RequestBody Player player) {
        return playerService.removePlayer(player);
    }
}
