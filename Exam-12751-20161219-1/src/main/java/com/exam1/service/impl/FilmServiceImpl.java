package com.exam1.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.exam1.dao.IFilmDao;
import com.exam1.dao.impl.FilmDaoImpl;
import com.exam1.pojo.Film;
import com.exam1.service.IFilmService;

public class FilmServiceImpl implements IFilmService {

	private IFilmDao iFilmDao = new FilmDaoImpl();

	@Override
	public List<Film> getFilmByPage(int page, int num) {
		List<Object> list = new ArrayList<Object>();
		list.add((page - 1) * num);
		list.add(num);
		return iFilmDao.selectPage(list);
	}

	@Override
	public int getCount() {
		return this.iFilmDao.selectCount();
	}

	@Override
	public boolean deleteFilmById(int id) {
		return  this.iFilmDao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean updateFilmById(Film record) {
		int result = this.iFilmDao.updateByPrimaryKey(record);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addFilm(Film record) {
		int result = this.iFilmDao.insert(record);
		if (result > 0) {
			return true;
		}
		return false;
	}

	/*public static void main(String[] args){
		FilmServiceImpl filmServiceImpl = new FilmServiceImpl();
		filmServiceImpl.getFilmByPage(1, 10);
	}*/
	
}
