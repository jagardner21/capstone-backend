package com.Galvanize.capstoneBackend.events;

import com.Galvanize.capstoneBackend.users.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "events")
@Data

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String type;

    @Column
    private int durationInMinutes;

    @Column
    private String date;
    //need some help with storing date so it can be used in charts
    //actually might not need work here, will need need to format dates elsewhere before they are inserted into the database
    //thinking is will be received as "yyyy-MM-dd"

    @Column
    private int user_id;
//    @ManyToOne
//    @JoinColumn
//    private User user;

    public Event(){}

}
