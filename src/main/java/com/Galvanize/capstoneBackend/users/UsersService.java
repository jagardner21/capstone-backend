package com.Galvanize.capstoneBackend.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) { this.usersRepository = usersRepository; }

    public List<User> getAllUsers(){ return this.usersRepository.findAll(); }

    public Optional<User> getOneUser(int id) { return this.usersRepository.findById(id); }

    public User addUser(User newUser) { return this.usersRepository.save(newUser); }

    public User updateUser(User updatedUser) { return this.usersRepository.save(updatedUser); }

    public String deleteUser(int id) {
        this.usersRepository.deleteById(id);
        return "The user of ID " + id + " was deleted.";
    }
}
