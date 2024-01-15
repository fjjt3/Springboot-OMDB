package com.omdb.demofilm.models.service;

import com.omdb.demofilm.models.entity.Film;

import java.util.List;

public interface IFilmService {

    public List<Film> findAll();

    public void save(Film film);

    public Film findOne(Long id);

    public void delete(Long id);
}
