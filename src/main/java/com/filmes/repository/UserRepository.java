package com.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmes.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
