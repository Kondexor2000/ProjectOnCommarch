package com.example.voices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Dodaj dodatkowe metody dostępowe, jeśli są potrzebne
}