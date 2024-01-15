package com.omdb.demofilm.controllers;


import com.omdb.demofilm.models.entity.Film;
import com.omdb.demofilm.models.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/v1")
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @GetMapping("/films")
    public List<Film> getFilms() {
        return filmService.findAll();
    }

    @PostMapping("/films")
    public ResponseEntity<String> addFilm(@RequestBody Film film) {
        filmService.save(film);
        return ResponseEntity.status(HttpStatus.CREATED).body("Film added successfully");
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Film film = filmService.findOne(id);
        if (film != null) {
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/films/{id}")
    public ResponseEntity<String> updateFilm(@PathVariable Long id, @RequestBody Film updatedFilm) {
        Film existingFilm = filmService.findOne(id);
        if (existingFilm != null) {
            updatedFilm.setId(id);
            filmService.save(updatedFilm);
            return ResponseEntity.ok("Film updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id) {
        Film existingFilm = filmService.findOne(id);
        if (existingFilm != null) {
            filmService.delete(id);
            return ResponseEntity.ok("Film deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }






}
