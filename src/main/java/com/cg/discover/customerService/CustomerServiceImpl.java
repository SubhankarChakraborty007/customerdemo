package com.cg.discover.customerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cg.discover.customerDao.CustomerDao;
import com.cg.discover.customerEntity.CustomerPojo;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	
	@Autowired
	private CustomerDao customerDao;
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public CustomerPojo getCustomerById(int customerId) {
		
		logger.info("getCustomerById() call from service implementation");
		CustomerPojo customer = customerDao.getCustomerById(customerId);
		logger.info("getCustomerById() callback from service implementation");
		return customer;
	}

	@Override
	public List<CustomerPojo> getAllCustomers() {

		return customerDao.getAllCustomers();
	}

	@Override
	public CustomerPojo insertCustomer(CustomerPojo customer) {

		if (customerDao.insertCustomer(customer)) {
			return customer;
		} else {
			return null;
		}

	}

	@Override
	public CustomerPojo updateCustomer(CustomerPojo customer) {

		if (customerDao.updateCustomer(customer)) {
			return customer;
		} else {
			return null;
		}
	}

	@Override
	public String deleteCustomerById(int customerId) {

		if (customerDao.deleteCustomerById(customerId)) {
			return "Successfully Deleted...";
		} else {
			return "Something went wrong !!!";
		}
	}


}
