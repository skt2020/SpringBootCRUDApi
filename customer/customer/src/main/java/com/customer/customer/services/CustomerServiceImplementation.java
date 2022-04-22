package com.customer.customer.services;

import com.customer.customer.entities.Customer;
import com.customer.customer.entities.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {
	
	
	List<Customer> list;
	CrudOperations crud;
	public CustomerServiceImplementation() {
		crud=new CrudOperations();
		
		// dummy data
		
	}
	
	
	
	@Override
	public Customer getCustomer(Long customerId) {
		// TODO Auto-generated method stub
		
		return crud.getCustomerById(customerId);
	}



	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		boolean status=crud.addNewCustomer(customer);
		if(status)
			return customer;
		else
			return null;
		
	}



	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean status=crud.updateCustomerDetails(customer);
		if(status)
			return customer;
		else
			return null;
	}



	@Override
	public void deleteCustomer(long customerId) {
		// TODO Auto-generated method stub
		crud.deleteCustomer(customerId);
		
	}



	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return crud.getCustomerList();
	}

}
