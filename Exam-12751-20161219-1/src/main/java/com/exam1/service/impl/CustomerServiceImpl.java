package com.exam1.service.impl;

import com.exam1.dao.ICustomerDao;
import com.exam1.dao.impl.CustomerDaoImpl;
import com.exam1.pojo.Customer;
import com.exam1.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
	
	private ICustomerDao iCustomerDao = new CustomerDaoImpl();

	@Override
	public Customer getCustomer(String name) {
		Customer customer =iCustomerDao.selectByFirstName(name);
		return customer;
	}

}
