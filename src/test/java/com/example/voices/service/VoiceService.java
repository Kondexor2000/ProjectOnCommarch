package com.example.voices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voices.model.Series;
import com.example.voices.model.Voice;
import com.example.voices.repository.SeriesRepository;
import com.example.voices.repository.VoiceRepository;

import java.util.Date;

@Service
public class VoiceService {

    @Autowired
    private VoiceRepository voiceRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    // Metoda do głosowania w danej serii przez użytkownika
    public void vote(Long userId, Long seriesId) {
        // Sprawdź, czy użytkownik już oddał głos w tej serii
        if (voiceRepository.existsByUserIdAndSeriesId(userId, seriesId)) {
            throw new IllegalStateException("Użytkownik już oddał głos w tej serii.");
        }

        // Znajdź aktywną serię
        Series activeSeries = seriesRepository.findActiveSeries();
        if (activeSeries == null) {
            throw new IllegalStateException("Brak aktywnej serii.");
        }

        // Sprawdź, czy użytkownik próbuje zagłosować w ramach poprawnej serii
        if (!activeSeries.getId().equals(seriesId)) {
            throw new IllegalStateException("Użytkownik próbuje zagłosować w niepoprawnej serii.");
        }

        // Utwórz nowy głos w ramach danej serii
        Voice voice = new Voice();
        voice.setUserId(userId);
        voice.setSeries(activeSeries);
        voice.setVoteDate(new Date());
        voiceRepository.save(voice);
    }
}