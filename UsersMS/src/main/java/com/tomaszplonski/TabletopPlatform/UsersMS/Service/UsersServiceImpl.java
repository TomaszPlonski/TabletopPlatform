package com.tomaszplonski.TabletopPlatform.UsersMS.Service;

import com.tomaszplonski.TabletopPlatform.UsersMS.data.UserEntity;
import com.tomaszplonski.TabletopPlatform.UsersMS.repository.UsersRepository;
import com.tomaszplonski.TabletopPlatform.UsersMS.shared.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserEntity createUsers(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

        userEntity.setEncryptedPassword("test");
        return usersRepository.save(userEntity);

    }
}
