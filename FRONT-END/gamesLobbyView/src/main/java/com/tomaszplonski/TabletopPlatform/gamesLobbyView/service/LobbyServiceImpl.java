package com.tomaszplonski.TabletopPlatform.gamesLobbyView.service;

import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.GameResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LobbyServiceImpl implements LobbyService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    @Override
    public Model showAllGames(Model model){
        String gamesListUrl = environment.getProperty("games.list.url");
        ResponseEntity<List<GameResponseModel>> gamesListResponse = restTemplate.exchange(gamesListUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GameResponseModel>>(){});
        model.addAttribute("allGames",gamesListResponse.getBody());
        return model;
    }


}
