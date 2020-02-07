package com.Galvanize.capstoneBackend.teams;

import com.Galvanize.capstoneBackend.users.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
@Data

public class Team {

    private Team(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "team_id")
    private List<User> users;


}
