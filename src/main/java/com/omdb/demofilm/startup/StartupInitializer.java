package com.omdb.demofilm.startup;

import com.omdb.demofilm.omdbService.OmdbService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class StartupInitializer {

    private final OmdbService omdbService;

    public StartupInitializer(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    @PostConstruct
    public void initialize() {
        omdbService.fetchAndSaveMovies();
    }
}
