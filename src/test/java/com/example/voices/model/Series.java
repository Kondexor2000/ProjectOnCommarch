package com.example.voices.model;
import javax.persistence.*;
import java.util.Set;


@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isActive;
    private int seriesNumber;
    // dodaj inne pola i metody dostępowe

    @OneToMany(mappedBy = "series")
    private Set<Voice> voices;

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public int getSeriesNumber() {
        return seriesNumber;
    }

    public void setActive(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'setActive'");
    }

    public void setSeriesNumber(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'setSeriesNumber'");
    }

    public void setFinished(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'setFinished'");
    }
}
