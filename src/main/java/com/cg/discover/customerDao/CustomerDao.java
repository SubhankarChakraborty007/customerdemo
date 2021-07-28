package com.cg.discover.customerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cg.discover.customerEntity.CustomerPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class CustomerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(CustomerDao.class);
	

	private final String GET_ALL = "SELECT * FROM customers";
	private final String GET_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE CUSTOMER_ID = ?";
	private final String INSERT_CUSTOMER = "INSERT INTO customers (CUSTOMER_ID, CUSTOMER_NAME,ACCOUNT_NUMBER ,ACCOUNT_BALANCE,LOAN_AMOUNT) values (?, ?, ?, ?, ?)";
	private final String UPDATE_CUSTOMER = "UPDATE customers set CUSTOMER_NAME = ?, ACCOUNT_BALANCE = ? WHERE CUSTOMER_ID = ?";
	private final String DELETE_CUSTOMER = "DELETE customers WHERE CUSTOMER_ID = ?";
	
	
	//GET DETALIS OF THE ACCOUNT HOLDER
	public CustomerPojo getCustomerById(int customerId) {

		logger.info("getCustomerById() request from dao class");
		
		CustomerPojo customer = jdbcTemplate.queryForObject(GET_CUSTOMER_BY_ID, (rs, rowNum) -> {
			return new CustomerPojo(rs.getInt("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getLong("ACCOUNT_NUMBER"),
					rs.getLong("ACCOUNT_BALANCE"), rs.getLong("LOAN_AMOUNT"));
		}, customerId);
		
		logger.info("getCustomerById() response from dao class");
		return customer;
	}

	//GET DETALIS OF ALL THE ACCOUNT HOLDERS
	public List<CustomerPojo> getAllCustomers() {

		return jdbcTemplate.query(GET_ALL, (rs, rowNum) -> {
			return new CustomerPojo(rs.getInt("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getLong("ACCOUNT_NUMBER"),
					rs.getLong("ACCOUNT_BALANCE"),rs.getLong("LOAN_AMOUNT"));
		});
	}
	
	
	//POST METHOD
	public boolean insertCustomer(CustomerPojo customer) {

		if (jdbcTemplate.update(INSERT_CUSTOMER, customer.getCustomerId(), customer.getCustomerName(),
				customer.getAccountNumber(),customer.getAccountBalance() ,customer.getLoanAmount()) > 0) {
			return true;
		} else {
			return false;
		}
	}

	//PUT METHOD
	public boolean updateCustomer(CustomerPojo customer) {

		if (jdbcTemplate.update(UPDATE_CUSTOMER, customer.getCustomerName(), customer.getAccountBalance(),
				customer.getCustomerId()) > 0) {
			return true;
		} else {
			return false;
		}
	}

	//DELETE METHOD
	public boolean deleteCustomerById(int customerId) {

		if (jdbcTemplate.update(DELETE_CUSTOMER, customerId) > 0) {
			return true;
		} else {
			return false;
		}
	}
}


