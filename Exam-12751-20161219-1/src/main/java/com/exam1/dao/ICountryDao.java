package com.exam1.dao;

import com.exam1.pojo.Country;

public interface ICountryDao {
    int deleteByPrimaryKey(Short countryId);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Short countryId);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}