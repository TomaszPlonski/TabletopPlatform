package com.tomaszplonski.TabletopPlatform.UsersMS.controllers;

import com.tomaszplonski.TabletopPlatform.UsersMS.Service.UsersService;
import com.tomaszplonski.TabletopPlatform.UsersMS.Service.UsersServiceImpl;
import com.tomaszplonski.TabletopPlatform.UsersMS.data.UserEntity;
import com.tomaszplonski.TabletopPlatform.UsersMS.model.CreateUserModel;
import com.tomaszplonski.TabletopPlatform.UsersMS.model.CreateUserResponseModel;
import com.tomaszplonski.TabletopPlatform.UsersMS.shared.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

   private final UsersService usersService;
   private final ModelMapper modelMapper;
   private final Environment environment;

    @GetMapping
    public String status(){
        return "Working.....";
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
                 )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserModel usersDetail){
        UserDto userDto = modelMapper.map(usersDetail, UserDto.class);
        UserEntity createdUser = usersService.createUsers(userDto);

        CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

        HttpStatus responseStatus = HttpStatus.CREATED;

        if(createdUser.getId()<0){
            responseStatus = HttpStatus.OK;
        }

        return ResponseEntity.status(responseStatus).body(returnValue);
    }
}
