package com.exam1.dao;

import com.exam1.pojo.Inventory;

public interface IInventoryDao {
    int deleteByPrimaryKey(Integer inventoryId);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer inventoryId);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}