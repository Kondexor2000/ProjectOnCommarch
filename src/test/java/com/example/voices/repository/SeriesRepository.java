package com.example.voices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voices.model.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

    Series findActiveSeries();
    // Dodaj dodatkowe metody dostępowe, jeśli są potrzebne
}