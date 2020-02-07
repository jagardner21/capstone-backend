package com.Galvanize.capstoneBackend.teams;

import com.Galvanize.capstoneBackend.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {
    @Autowired
    private final TeamsRepository teamsRepository;

    public TeamsService(TeamsRepository teamsRepository) { this.teamsRepository = teamsRepository; }

    public List<Team> getAllTeams() { return this.teamsRepository.findAll(); }

    public Optional<Team> getOneTeam(int id) { return this.teamsRepository.findById(id); }

    public Team addTeam(Team newTeam) {

        //trying to initialize the users list to an empty list
        //currently initializes as null
        List<User> users = new ArrayList<>();
        newTeam.setUsers(users);
        return this.teamsRepository.save(newTeam);
    }

    public Team updateTeam(Team updatedTeam) { return this.teamsRepository.save(updatedTeam); }

    public String deleteTeam(int id) {
        this.teamsRepository.deleteById(id);
        return "The Team of ID " + id + " was deleted";
    }
}
