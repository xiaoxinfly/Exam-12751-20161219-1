package com.exam1.dao;

import java.util.List;

import com.exam1.pojo.Language;

public interface ILanguageDao {
    int deleteByPrimaryKey(Byte languageId);

    int insert(Language record);

    int insertSelective(Language record);

    Language selectByPrimaryKey(Byte languageId);

    int updateByPrimaryKeySelective(Language record);

    int updateByPrimaryKey(Language record);
    
    List<Language> selectAll();
}