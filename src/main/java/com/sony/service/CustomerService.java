package com.sony.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.entity.Customer;
import com.sony.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> getAllCustomers()
	{
		return repo.findAll();
	}
	
	public Customer getCustomerById(String id) 
	{
		Optional<Customer> op = repo.findById(id);
		return op.isEmpty() ? null :op.get();
		
	}
	
	public Customer addNewCustomer(Customer customer)
	{
		return repo.save(customer);
	}
	
	public Customer updateCustomer(String id,Customer customer) 
	{
		customer.setCustomerId(id);
		return repo.save(customer);
	}
	
}
