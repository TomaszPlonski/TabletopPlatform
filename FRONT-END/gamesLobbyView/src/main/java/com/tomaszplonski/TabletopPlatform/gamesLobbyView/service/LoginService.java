package com.tomaszplonski.TabletopPlatform.gamesLobbyView.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.CreateUserResponseModel;
import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<CreateUserResponseModel> createUser(String firstName, String lastName, String password, String email) throws JsonProcessingException;
}
