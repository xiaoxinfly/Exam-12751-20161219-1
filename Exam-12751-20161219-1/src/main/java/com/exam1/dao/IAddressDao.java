package com.exam1.dao;

import com.exam1.pojo.Address;

public interface IAddressDao {
    int deleteByPrimaryKey(Short addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Short addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}