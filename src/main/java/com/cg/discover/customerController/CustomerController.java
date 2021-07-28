package com.cg.discover.customerController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.discover.customerEntity.CustomerPojo;
import com.cg.discover.customerService.CustomerServiceImpl;

@RestController
@RequestMapping(value= "/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerPojo> getCustomerById(@PathVariable int customerId) {

		logger.info("getCustomerById() call from controller");
		CustomerPojo customer = customerServiceImpl.getCustomerById(customerId);
		logger.info("getCustomerById() callback from controller");
		return new ResponseEntity<CustomerPojo>(customer, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<CustomerPojo>> getAllCustomers() {

		List<CustomerPojo> customer =  customerServiceImpl.getAllCustomers();
		return new ResponseEntity<List<CustomerPojo>>(customer, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<CustomerPojo> insertCustomer(@RequestBody CustomerPojo customer) {

		CustomerPojo cust =  customerServiceImpl.insertCustomer(customer);
		return new ResponseEntity<CustomerPojo>(cust, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<CustomerPojo> updateCustomer(@RequestBody CustomerPojo customer) {

		CustomerPojo cust =  customerServiceImpl.updateCustomer(customer);
		return new ResponseEntity<CustomerPojo>(cust, HttpStatus.OK);
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int customerId) {

		String c = customerServiceImpl.deleteCustomerById(customerId);
		return new ResponseEntity<String>(c, HttpStatus.OK);
	}

}
