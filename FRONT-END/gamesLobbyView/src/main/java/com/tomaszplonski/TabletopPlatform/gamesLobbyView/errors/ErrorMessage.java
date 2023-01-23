package com.tomaszplonski.TabletopPlatform.gamesLobbyView.errors;

public class ErrorMessage {
    protected String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
