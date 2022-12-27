package com.tomaszplonski.TabletopPlatform.UsersMS.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUsersModel {

    @NotNull (message = "First name cannot be null")
    @Size (min = 2, message = "First name must not be less than two characters")
    private String firstName;

    @NotNull (message = "Last name cannot be null")
    @Size (min = 2, message = "Last name must not be less than two characters")
    private String lastName;

    @NotNull (message = "Password cannot be null")
    @Size (min = 6, message = "Password must not be less than six characters")
    private String password;

    @NotNull (message = "Email cannot be null")
    @Email
    private String email;

}
