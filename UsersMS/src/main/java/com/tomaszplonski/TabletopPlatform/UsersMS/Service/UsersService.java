package com.tomaszplonski.TabletopPlatform.UsersMS.Service;

import com.tomaszplonski.TabletopPlatform.UsersMS.data.UserEntity;
import com.tomaszplonski.TabletopPlatform.UsersMS.shared.UserDto;

public interface UsersService {

    UserEntity createUsers(UserDto userDetails);
}
