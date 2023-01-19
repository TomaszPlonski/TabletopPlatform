package com.tomaszplonski.TabletopPlatform.gamesLobby.service;

import com.tomaszplonski.TabletopPlatform.gamesLobby.data.GamesLibraryEntity;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.CreateGameModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.GameResponseModel;

import java.util.List;

public interface GamesLibraryService {

    GamesLibraryEntity createGame(CreateGameModel game);

    public List<GameResponseModel> getAllGames();
}
