package com.tomaszplonski.TabletopPlatform.gamesLobby.service;

import com.tomaszplonski.TabletopPlatform.gamesLobby.data.GamesLibraryEntity;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.CreateGameModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.ListOfGamesResponseModel;
import org.springframework.http.ResponseEntity;

public interface GamesLibraryService {

    GamesLibraryEntity createGame(CreateGameModel game);

    public ListOfGamesResponseModel getAllGames();
}
