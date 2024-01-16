package com.omdb.demofilm.models.service;

import com.omdb.demofilm.models.dao.IFilmDao;
import com.omdb.demofilm.models.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements IFilmService{

    @Autowired
    private IFilmDao filmDao;

    @Override
    @Transactional(readOnly = true)
    public List<Film> findAll() {
        return (List<Film>) filmDao.findAll();
    }

    @Override
    @Transactional
    public void save(Film film) {
        filmDao.save(film);
    }

    @Override
    @Transactional(readOnly = true)
    public Film findOne(Long id) {
        Optional<Film> filmOptional = filmDao.findById(id);
        return filmOptional.orElse(null); //
    }

    @Override
    @Transactional
    public void delete(Long id) {
        filmDao.deleteById(id);
    }
}
