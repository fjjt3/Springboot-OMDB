package com.omdb.demofilm.omdbService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbService {
    private final RestTemplate restTemplate;

    @Value("${apikey}")
    private String apiKey;

    public OmdbService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void fetchAndSaveMovies() {

        ResponseEntity<String> response = restTemplate.getForEntity("http://www.omdbapi.com/?apikey=" + apiKey + "&s=movie&page=1", String.class);

    }
}
