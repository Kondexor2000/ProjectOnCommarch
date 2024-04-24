package com.example.voices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.voices.model.User;
import com.example.voices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Rejestracja nowego użytkownika
    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    // Logowanie użytkownika
    @PostMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    // Edycja danych użytkownika
    @PutMapping("/edit/{userId}")
    public void editProfile(@PathVariable Long userId, @RequestBody User updatedUser) {
        updatedUser.setId(userId);
        userService.editProfile(updatedUser);
    }

    // Usunięcie konta użytkownika
    @DeleteMapping("/delete/{userId}")
    public void deleteAccount(@PathVariable Long userId) {
        userService.deleteAccount(userId);
    }

    // Wylogowanie użytkownika (przy użyciu JWT)
    @PostMapping("/logout")
    public void logout(@RequestParam String token) {
        // Tutaj możesz zaimplementować logikę wylogowania użytkownika,
        // na przykład dodając przekazany token do czarnej listy tokenów
        // lub usuwając go z sesji.
    }
}