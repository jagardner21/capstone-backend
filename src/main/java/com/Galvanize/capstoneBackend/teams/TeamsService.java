package com.Galvanize.capstoneBackend.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {
    @Autowired
    private final TeamsRepository teamsRepository;

    public TeamsService(TeamsRepository teamsRepository) { this.teamsRepository = teamsRepository; }

    public List<Team> getAllTeams() { return this.teamsRepository.findAll(); }

    public Optional<Team> getOneTeam(int id) { return this.teamsRepository.findById(id); }

    public Team addTeam(Team newTeam) { return this.teamsRepository.save(newTeam); }

    public Team updateTeam(Team updatedTeam) { return this.teamsRepository.save(updatedTeam); }

    public String deleteTeam(int id) {
        this.teamsRepository.deleteById(id);
        return "The Team of ID " + id + " was deleted";
    }
}
