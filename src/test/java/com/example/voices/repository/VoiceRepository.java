package com.example.voices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voices.model.Voice;

@Repository
public interface VoiceRepository extends JpaRepository<Voice, Long> {

    boolean existsByUserIdAndSeriesId(Long userId, Long seriesId);
    // Dodaj dodatkowe metody dostępowe, jeśli są potrzebne
}