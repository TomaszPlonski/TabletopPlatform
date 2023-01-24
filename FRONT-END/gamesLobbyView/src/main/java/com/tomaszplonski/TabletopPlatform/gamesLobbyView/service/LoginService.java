package com.tomaszplonski.TabletopPlatform.gamesLobbyView.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.CreateUserResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface LoginService {

    ResponseEntity<CreateUserResponseModel> createUser(String firstName, String lastName, String password, String email) throws JsonProcessingException;

    String createUserUrlHandler(ResponseEntity<CreateUserResponseModel> responseEntity, Model model);

    ResponseEntity<String> logIn(String password, String email) throws JsonProcessingException;

    String logInUrlHandler(ResponseEntity<String> responseEntity, Model model);
}
