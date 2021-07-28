package com.cg.discover.customerService;

import java.util.List;

import com.cg.discover.customerEntity.CustomerPojo;

public interface ICustomerService {
	
	public CustomerPojo getCustomerById(int customerId);
	public List<CustomerPojo> getAllCustomers();
	public CustomerPojo insertCustomer(CustomerPojo customer);
	public CustomerPojo updateCustomer(CustomerPojo customer);
	public String deleteCustomerById(int customerId);


}
