package com.exam1.dao;

import com.exam1.pojo.Store;

public interface IStoreDao {
    int deleteByPrimaryKey(Byte storeId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Byte storeId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}