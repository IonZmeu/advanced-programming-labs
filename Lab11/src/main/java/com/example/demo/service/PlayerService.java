package com.example.demo.service;

import com.example.demo.data.Player;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class PlayerService {
    private final List<Player> playerList;

    public PlayerService() {
        playerList = new ArrayList<>();
    }

    public Player getById(int id){
        return playerList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public int createNewPlayerFromObject(Player player){
        int id = 1 + playerList.size();
        player.setId(id);
        playerList.add(player);
        return id;
    }

    public ResponseEntity<String> modifyPlayerNumber(Player playerToModify,int playerNumber) {
        Player player = getById(playerToModify.getId());
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
        }
        player.setPlayerNumber(playerNumber);
        return new ResponseEntity<>(
                "Player updated successsfully", HttpStatus.OK);
    }

    public ResponseEntity<String> modifyPlayerName(Player playerToModify,String name) {
        Player player = getById(playerToModify.getId());
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
        }
        player.setName(name);
        return new ResponseEntity<>(
                "Player updated successsfully", HttpStatus.OK);
    }

    public ResponseEntity<String> removePlayer(Player playerToRemove){
        Player player = getById(playerToRemove.getId());
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.GONE);
        }
        playerList.remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }
}
