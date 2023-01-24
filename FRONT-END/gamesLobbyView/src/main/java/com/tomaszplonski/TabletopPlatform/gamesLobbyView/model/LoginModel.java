package com.tomaszplonski.TabletopPlatform.gamesLobbyView.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginModel implements Serializable {
    private static final long serialVersionUID = -6737355196463584539L;
    private String email;
    private String password;


    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
