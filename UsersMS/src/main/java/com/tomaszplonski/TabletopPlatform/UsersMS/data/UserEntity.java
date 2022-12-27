package com.tomaszplonski.TabletopPlatform.UsersMS.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 8042599466310131550L;

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

}
