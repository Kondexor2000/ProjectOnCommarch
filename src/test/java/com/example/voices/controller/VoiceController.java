package com.example.voices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.voices.service.VoiceService;

@RestController
public class VoiceController {

    @Autowired
    private VoiceService voiceService;

    @PostMapping("/vote")
    public void vote(Long userId, Long seriesId) {
        voiceService.vote(userId, seriesId);
    }
}