package com.tomaszplonski.TabletopPlatform.gamesLobby.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateGameModel {

    @NotNull(message = "Game name cannot be null")
    @Size(min = 2, message = "Game name must not be less than two characters")
    private String name;

    @Min(value = 1,message = "Minimal numbers of players should be greater than 0")
    private int minNumberOfPlayers;

    //TODO validate maxNumberOfPlayers -> min should be greater or equal than minNumberOfPlayers
    @Min(value = 1,message = "Maximum numbers of players should be greater than 0")
    private int maxNumberOfPlayers;
}
