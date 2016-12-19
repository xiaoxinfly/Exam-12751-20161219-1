package com.exam1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam1.dao.ICustomerDao;
import com.exam1.pojo.Customer;
import com.exam1.util.DBUtil;
import com.exam1.util.SQLUitl;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public int deleteByPrimaryKey(Short customerId) {
		return 0;
	}

	@Override
	public int insert(Customer record) {
		return 0;
	}

	@Override
	public int insertSelective(Customer record) {
		return 0;
	}

	@Override
	public Customer selectByPrimaryKey(Short customerId) {
		List<Object> list = new ArrayList<Object>();
		list.add(customerId);
		ResultSet resultSet = DBUtil.query(SQLUitl.CUSTOMER_LOGIN, list);
		Customer customer = null;
		try {
			while (resultSet.next()) {
				customer = new Customer();
				System.out.println(resultSet.getInt("active"));
				customer.setActive(resultSet.getBoolean("active"));
				customer.setAddressId(resultSet.getShort("address_id"));
				customer.setCreateDate(resultSet.getDate("create_date"));
				customer.setCustomerId(resultSet.getShort("customer_id"));
				customer.setEmail(resultSet.getString("email"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setLastUpdate(resultSet.getDate("last_update"));
				customer.setStoreId(resultSet.getByte("store_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int updateByPrimaryKeySelective(Customer record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Customer record) {
		return 0;
	}

	@Override
	public Customer selectByFirstName(String name) {
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		ResultSet resultSet = DBUtil.query(SQLUitl.CUSTOMER_LOGIN, list);
		Customer customer = null;
		try {
			while (resultSet.next()) {
				customer = new Customer();
				customer.setActive(resultSet.getBoolean("active"));
				customer.setAddressId(resultSet.getShort("address_id"));
				customer.setCreateDate(resultSet.getDate("create_date"));
				customer.setCustomerId(resultSet.getShort("customer_id"));
				customer.setEmail(resultSet.getString("email"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setLastUpdate(resultSet.getDate("last_update"));
				customer.setStoreId(resultSet.getByte("store_id"));
			}
			DBUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}
