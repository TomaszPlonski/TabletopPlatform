package com.tomaszplonski.TabletopPlatform.gamesLobbyView.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ArrayListMultimap;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.CreateUserModel;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.CreateUserResponseModel;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.model.LoginModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
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
    private final ObjectMapper mapper;
    private final ErrorService errorService;

    @Override
    public ResponseEntity<CreateUserResponseModel> createUser(String firstName, String lastName, String password, String email) throws JsonProcessingException {
        CreateUserModel createUserModel = new CreateUserModel(firstName,lastName,password,email);
        String registerURL = environment.getProperty("register.url");

        String jsonCreateUserModel = mapper.writeValueAsString(createUserModel);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept((Collections.singletonList(MediaType.APPLICATION_JSON)));
        HttpEntity<String> request = new HttpEntity<>(jsonCreateUserModel,headers);

        return restTemplate.postForEntity(registerURL,request, CreateUserResponseModel.class);
    }

    @Override
    public String createUserUrlHandler(ResponseEntity<CreateUserResponseModel> responseEntity, Model model){

        HttpStatus responseStatus = responseEntity.getStatusCode();

        if(responseStatus.equals(HttpStatus.CREATED)){
            return "redirect:/login";
        }
        String errorMessage = "Failed to create a new account";
        errorService.setErrorAttribute(model,errorMessage);
        return "error";
    }

    @Override
    public ResponseEntity<String> logIn(String password, String email) throws JsonProcessingException{
        LoginModel loginModel = new LoginModel(email,password);
        String loginURL = environment.getProperty("login.url");

        String jsonLoginModel = mapper.writeValueAsString(loginModel);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(jsonLoginModel,headers);

        try{
           return restTemplate.postForEntity(loginURL,request,String.class);
        } catch (HttpClientErrorException e){
            return ResponseEntity.status(HttpStatus.CONTINUE).build();
        }


    }

    @Override
    public String logInUrlHandler(ResponseEntity<String> responseEntity, Model model){

        HttpStatus responseStatus = responseEntity.getStatusCode();

        if(responseStatus.equals(HttpStatus.OK)){
//            return "redirect:/login";

            String errorMessage = "Logged";
            errorService.setErrorAttribute(model,errorMessage);
            return "error";

        }
        String errorMessage = "Failed to create log in";
        errorService.setErrorAttribute(model,errorMessage);
        return "error";

    }

}
