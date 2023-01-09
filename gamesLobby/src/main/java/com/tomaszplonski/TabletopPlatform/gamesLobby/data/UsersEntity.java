package com.tomaszplonski.TabletopPlatform.gamesLobby.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = -4639099128079269025L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 120, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String encryptedPassword;

    @ManyToMany
    @JoinTable(
            name = "players_matches",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn (name = "match_id"))
    Set<MatchesEntity> matches;

}
