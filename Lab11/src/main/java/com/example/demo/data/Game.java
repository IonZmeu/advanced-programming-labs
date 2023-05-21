package com.example.demo.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    @Column(columnDefinition = "json")
    private String boardArray;

    @OneToMany
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private List<Player> players;
}
