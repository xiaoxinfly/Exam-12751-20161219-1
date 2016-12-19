package com.exam1.service;

import java.util.List;

import com.exam1.pojo.Film;

public interface IFilmService {

	List<Film> getFilmByPage(int page, int num);

	int getCount();

	boolean deleteFilmById(int id);

	boolean updateFilmById(Film record);

	boolean addFilm(Film record);

}
