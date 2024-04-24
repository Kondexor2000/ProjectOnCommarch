package com.example.voices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voices.model.Series;
import com.example.voices.repository.SeriesRepository;

import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    // Metoda do rozpoczęcia nowej serii głosowania
    public void startNewSeries() {
        // Znajdź aktualną aktywną serię
        Series activeSeries = seriesRepository.findActiveSeries();
        if (activeSeries != null) {
            activeSeries.setActive(false);
            seriesRepository.save(activeSeries);
        }
        // Utwórz nową serię i ustaw ją jako aktywną
        Series newSeries = new Series();
        newSeries.setActive(true);
        newSeries.setSeriesNumber(activeSeries != null ? activeSeries.getSeriesNumber() + 1 : 1);
        seriesRepository.save(newSeries);
    }

    // Metoda do zakończenia konkursu po pięciu serii
    public void endContest() {
        List<Series> allSeries = seriesRepository.findAll();
        if (allSeries.size() >= 5) {
            // Oznacz konkurs jako zakończony
            // Możesz dodać odpowiednią logikę lub flagę w bazie danych
            for (Series series : allSeries) {
                series.setFinished(true);
                seriesRepository.save(series);
            }
        }
    }
}