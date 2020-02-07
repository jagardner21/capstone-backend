package com.Galvanize.capstoneBackend.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public List<User> getAllUsers(){ return this.usersService.getAllUsers(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<User> getOneUser(@PathVariable int id){
        return this.usersService.getOneUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User newUser){ return this.usersService.addUser(newUser); }

    @PatchMapping
    public User updateUser(User updatedUser) {
        User user = this.usersService.getOneUser(updatedUser.getId()).orElseThrow(IllegalArgumentException::new);
        return this.usersService.updateUser(updatedUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        User user = this.usersService.getOneUser(id).orElseThrow(IllegalArgumentException::new);
        return this.usersService.deleteUser(id);
    }
}
