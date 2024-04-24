package com.example.voices.model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    // dodaj inne pola i metody dostępowe

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @OneToMany(mappedBy = "user")
    private Set<Voice> voices;

    public boolean isActive() {
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }

    public void setId(Long userId) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public void setRole(Role user) {
        throw new UnsupportedOperationException("Unimplemented method 'setRole'");
    }
}
