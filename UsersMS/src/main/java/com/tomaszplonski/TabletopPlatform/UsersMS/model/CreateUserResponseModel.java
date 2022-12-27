package com.tomaszplonski.TabletopPlatform.UsersMS.model;

import lombok.Data;

@Data
public class CreateUserResponseModel {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
