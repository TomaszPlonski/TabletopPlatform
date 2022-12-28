package com.tomaszplonski.TabletopPlatform.UsersMS.repository;

import com.tomaszplonski.TabletopPlatform.UsersMS.data.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
