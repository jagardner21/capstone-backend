package com.Galvanize.capstoneBackend.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamsController {
    @Autowired
    private final TeamsService teamsService;

    public TeamsController(TeamsService teamsService) { this.teamsService = teamsService; }

    @GetMapping
    public List<Team> getAllTeams() { return this.teamsService.getAllTeams(); }

    @GetMapping("/{id}")
    public Optional<Team> getOneTeam(@PathVariable int id) { return this.teamsService.getOneTeam(id); }

    @PostMapping
    public Team addTeam(@RequestBody Team newTeam) { return this.teamsService.addTeam(newTeam); }

    @PatchMapping
    public Team updateTeam(@RequestBody Team updatedTeam){
        Team team = this.teamsService.getOneTeam(updatedTeam.getId()).orElseThrow(IllegalArgumentException::new);
        return this.teamsService.updateTeam(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable int id){
        Team team = this.teamsService.getOneTeam(id).orElseThrow(IllegalArgumentException::new);
        return this.teamsService.deleteTeam(id);
    }
}
