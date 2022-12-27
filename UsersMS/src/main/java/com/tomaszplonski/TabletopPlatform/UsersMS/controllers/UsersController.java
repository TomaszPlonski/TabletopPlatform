package com.tomaszplonski.TabletopPlatform.UsersMS.controllers;

import com.tomaszplonski.TabletopPlatform.UsersMS.model.CreateUsersModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping
    public String status(){
        return "Working.....";
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUsersModel usersDetail){
        return "Create user method______________________________________________!!!";
    }

}
