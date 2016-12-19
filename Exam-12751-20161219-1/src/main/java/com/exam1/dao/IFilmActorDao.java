package com.exam1.dao;

import com.exam1.pojo.FilmActor;
import com.exam1.pojo.FilmActorKey;

public interface IFilmActorDao {
    int deleteByPrimaryKey(FilmActorKey key);

    int insert(FilmActor record);

    int insertSelective(FilmActor record);

    FilmActor selectByPrimaryKey(FilmActorKey key);

    int updateByPrimaryKeySelective(FilmActor record);

    int updateByPrimaryKey(FilmActor record);
}