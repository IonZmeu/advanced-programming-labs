package org.ionn;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.Socket;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Player {
    private String playerId;
    private Socket socket;

}
