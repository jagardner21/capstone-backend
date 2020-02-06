package com.Galvanize.capstoneBackend.teams;

import com.Galvanize.capstoneBackend.users.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
@Data

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "teams")
    private Set<User> users;

    private Team(){}
}
