package com.tomaszplonski.TabletopPlatform.gamesLobby.controllers;

import com.tomaszplonski.TabletopPlatform.gamesLobby.model.CreateGameModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.GameResponseModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.service.GamesLibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class LobbyController {

    private final GamesLibraryService gamesLibraryService;

    @GetMapping("/add")
    public String test(){
        Random r = new Random();
        CreateGameModel gameModel = new CreateGameModel(String.valueOf(r.nextInt(900900000)), 1, 2);
        return gamesLibraryService.createGame(gameModel).toString();
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    private ResponseEntity<List<GameResponseModel>> gameList(){

        return ResponseEntity.status(HttpStatus.OK).body(gamesLibraryService.getAllGames());

    }

}
