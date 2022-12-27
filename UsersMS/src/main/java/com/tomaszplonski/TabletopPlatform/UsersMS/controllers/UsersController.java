package com.tomaszplonski.TabletopPlatform.UsersMS.controllers;

import com.tomaszplonski.TabletopPlatform.UsersMS.Service.UsersServiceImpl;
import com.tomaszplonski.TabletopPlatform.UsersMS.data.UserEntity;
import com.tomaszplonski.TabletopPlatform.UsersMS.model.CreateUserModel;
import com.tomaszplonski.TabletopPlatform.UsersMS.model.CreateUserResponseModel;
import com.tomaszplonski.TabletopPlatform.UsersMS.shared.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserModel usersDetail){
        UserDto userDto = modelMapper.map(usersDetail, UserDto.class);
        UserEntity createdUser = usersService.createUsers(userDto);

        CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
