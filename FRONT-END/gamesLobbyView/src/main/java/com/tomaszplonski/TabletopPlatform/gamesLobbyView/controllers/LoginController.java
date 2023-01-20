package com.tomaszplonski.TabletopPlatform.gamesLobbyView.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.service.LobbyService;
import com.tomaszplonski.TabletopPlatform.gamesLobbyView.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

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

        return loginService.createUser(firstName,lastName,password,email).getStatusCode().toString();
    }

}
