package com.tomaszplonski.TabletopPlatform.gamesLobby.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "games_libary")
@Data
public class GamesLibraryEntity implements Serializable {

    private static final long serialVersionUID = -6085106149773510504L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true, length = 120)
    private String name;

    @Column(nullable = false)
    private int minNumberOfPlayers;

    //TODO validate maxNumberOfPlayers -> min should be greater or equal than minNumberOfPlayers
    @Column(nullable = false)
    private int maxNumberOfPlayers;

}
