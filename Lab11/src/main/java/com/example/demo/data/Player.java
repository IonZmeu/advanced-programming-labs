package com.example.demo.data;

import com.example.demo.serializer.SocketSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int playerNumber;
    @JsonSerialize(using = SocketSerializer.class)
    private String socket;
    private String name;

    public Player(String socket) {
        this.socket = socket;
    }

}
