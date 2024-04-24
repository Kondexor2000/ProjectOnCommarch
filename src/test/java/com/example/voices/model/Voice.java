package com.example.voices.model;
import javax.persistence.*;
import java.util.Date;

public class Voice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    private Date voteDate;
    // dodaj inne pola i metody 
    
    public Date getId() {
        return voteDate;
    }

    public void setUserId(Long userId) {
        throw new UnsupportedOperationException("Unimplemented method 'setUserId'");
    }

    public void setSeries(Series activeSeries) {
        throw new UnsupportedOperationException("Unimplemented method 'setSeries'");
    }

    public void setVoteDate(Date date) {
        throw new UnsupportedOperationException("Unimplemented method 'setVoteDate'");
    }
}
