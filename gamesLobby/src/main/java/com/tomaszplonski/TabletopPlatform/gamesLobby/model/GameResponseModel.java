package com.tomaszplonski.TabletopPlatform.gamesLobby.model;

import lombok.Data;

@Data
public class GameResponseModel {

    private String name;
    private int minNumberOfPlayers;
    private int maxNumberOfPlayers;

}
