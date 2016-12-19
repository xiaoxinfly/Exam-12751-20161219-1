package com.exam1.dao;

import com.exam1.pojo.Customer;

public interface ICustomerDao {
    int deleteByPrimaryKey(Short customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Short customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    //以上是自动生成的方法，以下是自定义方法
    Customer selectByFirstName(String name);
}