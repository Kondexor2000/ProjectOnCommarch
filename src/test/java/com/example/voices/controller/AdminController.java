package com.example.voices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.voices.model.Project;
import com.example.voices.service.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/manage/series")
    public void manageSeries() {
        adminService.manageSeries();
    }

    @PostMapping("/manage/users")
    public void manageUsers() {
        adminService.manageUsers();
    }

    @PostMapping("/manage/projects")
    public void manageProjects(Project newProject) {
        adminService.manageProjects(newProject);
    }
}