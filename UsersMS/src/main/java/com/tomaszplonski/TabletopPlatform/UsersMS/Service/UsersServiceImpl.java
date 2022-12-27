package com.tomaszplonski.TabletopPlatform.UsersMS.Service;

import com.tomaszplonski.TabletopPlatform.UsersMS.shared.UserDto;

import java.util.UUID;

public class UsersServiceImpl implements UsersService {

    @Override
    public UserDto createUsers(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        return null;
    }
}
