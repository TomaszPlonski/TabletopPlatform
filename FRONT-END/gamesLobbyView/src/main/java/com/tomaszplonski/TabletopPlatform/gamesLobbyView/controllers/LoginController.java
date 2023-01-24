package com.tomaszplonski.TabletopPlatform.gamesLobbyView.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String password,
                               @RequestParam String email,
                               Model model) throws JsonProcessingException {

        return loginService.createUserUrlHandler(loginService.createUser(firstName,lastName,password,email), model);

    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String password,
                             @RequestParam String email,
                             Model model) throws JsonProcessingException {

        ResponseEntity<String> responseEntity= loginService.logIn(password, email);
        return loginService.logInUrlHandler(responseEntity,model);

    }

}
