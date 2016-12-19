package com.exam1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam1.dao.IFilmDao;
import com.exam1.pojo.Film;
import com.exam1.util.DBUtil;
import com.exam1.util.SQLUitl;

public class FilmDaoImpl implements IFilmDao {

	@Override
	public boolean deleteByPrimaryKey(int filmId) {
		boolean result = false;
		DBUtil.delete(SQLUitl.DELETE_RENTAL, filmId);
		DBUtil.delete(SQLUitl.DELETE_INVENTORY, filmId);
		DBUtil.delete(SQLUitl.DELETE_FILM_CATEGORY, filmId);
		DBUtil.delete(SQLUitl.DELETE_FILM_TEXT, filmId);
		DBUtil.delete(SQLUitl.DELETE_FILM_ACTOR, filmId);
		//execute()方法返回false表示执行DDL语句等，并不是错误
		if(!DBUtil.delete(SQLUitl.FILM_DELETE, filmId)){
			result = true;
		}
		try {
			DBUtil.close();
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}

	@Override
	public int insert(Film record) {
		int result = 0;
		List<Object> list = new ArrayList<Object>();
		list.add(record.getTitle());
		list.add(record.getDescription());
		list.add(record.getLanguageId());
		result = DBUtil.update(SQLUitl.FILM_INSERT, list);
		try {
			DBUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertSelective(Film record) {
		return 0;
	}

	@Override
	public Film selectByPrimaryKey(Short filmId) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Film record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Film record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Film record) {
		List<Object> list = new ArrayList<Object>();
		list.add(record.getTitle());
		list.add(record.getDescription());
		list.add(record.getLanguageId());
		list.add(record.getFilmId());
		int result = 0;
		result = DBUtil.update(SQLUitl.FILM_UPDATE, list);
		try {
			DBUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int selectCount() {
		int result = 0;
		ResultSet resultSet = DBUtil.query(SQLUitl.FILM_COUNT);
		try {
			while (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 这里就不拿全部的数据过去了，有点小麻烦
	@Override
	public List<Film> selectPage(List<Object> list) {
		List<Film> filmList = new ArrayList<Film>();
		ResultSet resultSet = DBUtil.query(SQLUitl.FILM_SELECT_PAGE, list);
		try {
			while (resultSet.next()) {
				Film film = new Film();
				film.setFilmId(resultSet.getShort("film_id"));
				film.setTitle(resultSet.getString("title"));
				film.setDescription(resultSet.getString("description"));
				film.setLanguageName(resultSet.getString("language_name"));
				filmList.add(film);
			}
			DBUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
	}

}
