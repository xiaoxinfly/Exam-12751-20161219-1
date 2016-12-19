package com.exam1.dao;

import com.exam1.pojo.Rental;

public interface IRentalDao {
    int deleteByPrimaryKey(Integer rentalId);

    int insert(Rental record);

    int insertSelective(Rental record);

    Rental selectByPrimaryKey(Integer rentalId);

    int updateByPrimaryKeySelective(Rental record);

    int updateByPrimaryKey(Rental record);
}