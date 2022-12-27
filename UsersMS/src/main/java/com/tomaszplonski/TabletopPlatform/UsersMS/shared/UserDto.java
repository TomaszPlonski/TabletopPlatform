package com.tomaszplonski.TabletopPlatform.UsersMS.shared;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 2450693554004781593L;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String userId;
    private String encryptedPassword;

}
