package com.example.voices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voices.model.Project;
import com.example.voices.model.ProjectStatus;
import com.example.voices.model.Role;
import com.example.voices.model.User;
import com.example.voices.repository.AdminRepository;
import com.example.voices.repository.UserRepository;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private SeriesService seriesService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    // Metoda do zarządzania seriami przez administratora
    public void manageSeries() {
        seriesService.startNewSeries();
        seriesService.endContest();
    }

    // Metoda do zarządzania użytkownikami przez administratora
    public void manageUsers() {
        List<User> users = userRepository.findAll();
        // Przykładowa logika zarządzania użytkownikami
        for (User user : users) {
            if (user.isActive()) {
                user.setRole(Role.ADMIN); // Przykładowa operacja - nadanie roli administratora
                userRepository.save(user); // Zapisz zmiany w repozytorium
            } else {
                user.setRole(Role.USER); // Przykładowa operacja - zmiana roli na użytkownika
                userRepository.save(user); // Zapisz zmiany w repozytorium
            }
        }
    }

    // Metoda do zarządzania projektami przez administratora
    public void manageProjects(Project newProject) {
        if (newProject != null) {
            adminRepository.save(newProject); // Dodaj nowy projekt do repozytorium
        } else {
            List<Project> projects = adminRepository.findAll();
            // Przykładowa logika zarządzania projektami
            for (Project project : projects) {
                if (project.isApproved()) {
                    project.setStatus(ProjectStatus.ARCHIVED); // Przykładowa operacja - zmiana statusu na zarchiwizowany
                    adminRepository.save(project); // Zapisz zmiany w repozytorium
                } else {
                    project.setStatus(ProjectStatus.PENDING); // Przykładowa operacja - ustawienie statusu na oczekujący
                    adminRepository.save(project); // Zapisz zmiany w repozytorium
                }
            }
        }
    }
}