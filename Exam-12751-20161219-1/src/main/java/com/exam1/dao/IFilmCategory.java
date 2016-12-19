package com.exam1.dao;

import com.exam1.pojo.FilmCategory;
import com.exam1.pojo.FilmCategoryKey;

public interface IFilmCategory {
    int deleteByPrimaryKey(FilmCategoryKey key);

    int insert(FilmCategory record);

    int insertSelective(FilmCategory record);

    FilmCategory selectByPrimaryKey(FilmCategoryKey key);

    int updateByPrimaryKeySelective(FilmCategory record);

    int updateByPrimaryKey(FilmCategory record);
}