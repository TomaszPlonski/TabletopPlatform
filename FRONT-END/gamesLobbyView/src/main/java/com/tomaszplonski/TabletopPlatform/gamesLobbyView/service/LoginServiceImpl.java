package com.tomaszplonski.TabletopPlatform.gamesLobbyView.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ArrayListMultimap;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.CreateUserModel;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.CreateUserResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    @Override
    public ResponseEntity<CreateUserResponseModel> createUser(String firstName, String lastName, String password, String email) throws JsonProcessingException {
        CreateUserModel createUserModel = new CreateUserModel(firstName,lastName,password,email);
        String registerURL = environment.getProperty("register.url");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        String jsonCreateUserModel = mapper.writeValueAsString(createUserModel);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((Collections.singletonList(MediaType.APPLICATION_JSON)));
        HttpEntity<String> request = new HttpEntity<>(jsonCreateUserModel,headers);

        return restTemplate.postForEntity(registerURL,request, CreateUserResponseModel.class);
    }
}
