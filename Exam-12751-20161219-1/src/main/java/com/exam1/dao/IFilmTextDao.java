package com.exam1.dao;

import com.exam1.pojo.FileText;

public interface IFilmTextDao {
    int deleteByPrimaryKey(Short filmId);

    int insert(FileText record);

    int insertSelective(FileText record);

    FileText selectByPrimaryKey(Short filmId);

    int updateByPrimaryKeySelective(FileText record);

    int updateByPrimaryKeyWithBLOBs(FileText record);

    int updateByPrimaryKey(FileText record);
}