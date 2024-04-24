package com.example.voices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voices.model.Project;

@Repository
public interface AdminRepository extends JpaRepository<Project, Long> {
    // Dodaj dodatkowe metody dostępowe, jeśli są potrzebne
}