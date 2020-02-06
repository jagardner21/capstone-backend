package com.Galvanize.capstoneBackend.users;

import com.Galvanize.capstoneBackend.events.Event;
import com.Galvanize.capstoneBackend.teams.Team;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Team team;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

    public User(){}
}
