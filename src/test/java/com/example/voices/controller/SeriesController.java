package com.example.voices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.voices.service.SeriesService;

@RestController
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @PostMapping("/startNewSeries")
    public void startNewSeries() {
        seriesService.startNewSeries();
    }

    @PostMapping("/endContest")
    public void endContest() {
        seriesService.endContest();
    }
}