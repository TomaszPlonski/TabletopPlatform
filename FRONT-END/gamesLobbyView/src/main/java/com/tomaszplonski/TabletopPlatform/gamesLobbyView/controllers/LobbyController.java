package com.tomaszplonski.TabletopPlatform.gamesLobbyView.controllers;


import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.GameResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/view")
@RequiredArgsConstructor
public class LobbyController {

    private final RestTemplate restTemplate;
    private final Environment environment;

    @GetMapping("/allGames")
    public String showAllGames(Model model){

        String gamesListUrl = environment.getProperty("games.list.url");

        ResponseEntity<List<GameResponseModel>> gamesListResponse = restTemplate.exchange(gamesListUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GameResponseModel>>(){});

        model.addAttribute("allGames",gamesListResponse.getBody());

        return "allGames";
    }


}
