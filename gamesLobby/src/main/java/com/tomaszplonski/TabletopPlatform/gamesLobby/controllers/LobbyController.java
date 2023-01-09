package com.tomaszplonski.TabletopPlatform.gamesLobby.controllers;

import com.tomaszplonski.TabletopPlatform.gamesLobby.model.CreateGameModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.service.GamesLibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class LobbyController {

    private final GamesLibraryService gamesLibraryService;

    @GetMapping
    public String test(){
        Random r = new Random();
        CreateGameModel gameModel = new CreateGameModel(String.valueOf(r.nextInt(900900000)), 1, 2);
        return gamesLibraryService.createGame(gameModel).toString();
    }
}
