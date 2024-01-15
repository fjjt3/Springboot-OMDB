package com.omdb.demofilm.models.dao;

import com.omdb.demofilm.models.entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface IFilmDao extends CrudRepository<Film, Long> {

}
