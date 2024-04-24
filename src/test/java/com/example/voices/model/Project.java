package com.example.voices.model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // dodaj inne pola i metody dostępowe

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "project")
    private Set<Voice> voices;

    public boolean isApproved() {
        throw new UnsupportedOperationException("Unimplemented method 'isApproved'");
    }

    public void setStatus(ProjectStatus archived) {
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }
}
