package com.tomaszplonski.TabletopPlatform.gamesLobbyView.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateUserModel implements Serializable {

    private static final long serialVersionUID = 4510403298491589603L;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public CreateUserModel(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }
}
