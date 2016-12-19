package com.exam1.dao;

import com.exam1.pojo.Payment;

public interface IPaymentDao {
    int deleteByPrimaryKey(Short paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Short paymentId);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}