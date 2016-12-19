package com.exam1.dao;

import java.util.List;

import com.exam1.pojo.Film;

public interface IFilmDao {
    boolean deleteByPrimaryKey(int id);

    int insert(Film record);

    int insertSelective(Film record);

    Film selectByPrimaryKey(Short filmId);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);
    
    int selectCount();
    
    List<Film> selectPage(List<Object> list);
 }