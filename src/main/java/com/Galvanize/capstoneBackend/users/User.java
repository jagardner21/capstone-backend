package com.Galvanize.capstoneBackend.users;

import com.Galvanize.capstoneBackend.events.Event;
import com.Galvanize.capstoneBackend.teams.Team;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data

public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int team_id;
//    @ManyToOne
//    @JoinColumn
//    private Team team;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Event> events;


}
