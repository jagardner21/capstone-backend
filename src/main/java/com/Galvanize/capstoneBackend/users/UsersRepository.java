package com.Galvanize.capstoneBackend.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <User, Integer> {
}
