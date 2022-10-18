package com.dao;

import java.util.List;

import com.data.Film;

public interface FilmDAO {

	public void postFilm(Film f);

	public Film getFilmById(Long id);

	public List<Film> getFilmByDirector(String director);

	public List<Film> getAllFilms();

	public void putFilm(Film f);

	public void deleteFilm(Long id);
}
