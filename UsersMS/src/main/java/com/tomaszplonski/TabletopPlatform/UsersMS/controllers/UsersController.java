package com.tomaszplonski.TabletopPlatform.UsersMS.controllers;

import com.tomaszplonski.TabletopPlatform.UsersMS.Service.UsersServiceImpl;
import com.tomaszplonski.TabletopPlatform.UsersMS.model.CreateUsersModel;
import com.tomaszplonski.TabletopPlatform.UsersMS.shared.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

   private final UsersServiceImpl usersService;
   private final ModelMapper modelMapper;

    @GetMapping
    public String status(){
        return "Working.....";
    }

    @PostMapping
        public String createUser(@Valid @RequestBody CreateUsersModel usersDetail){

        UserDto userDto = modelMapper.map(usersDetail, UserDto.class);

        return usersService.createUsers(userDto).toString();
    }
}
