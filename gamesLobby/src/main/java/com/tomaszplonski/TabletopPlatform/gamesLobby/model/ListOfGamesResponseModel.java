package com.tomaszplonski.TabletopPlatform.gamesLobby.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListOfGamesResponseModel {

    private List<GameResponseModel> games;

    public ListOfGamesResponseModel() {
        this.games = new ArrayList<>();
    }

    public void addGameToList(GameResponseModel game){
        games.add(game);
    }

}
