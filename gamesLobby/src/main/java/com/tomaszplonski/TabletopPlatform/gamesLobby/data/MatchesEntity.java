package com.tomaszplonski.TabletopPlatform.gamesLobby.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "matches")
@Data
public class MatchesEntity implements Serializable {

    private static final long serialVersionUID = -4760273864463601374L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String matchId;

    private boolean matchFinished;

    @ManyToOne
    @JoinColumn(name = "name")
    private GamesLibraryEntity gameName;

    @ManyToMany(mappedBy = "matches")
    Set<UsersEntity> players;


}
