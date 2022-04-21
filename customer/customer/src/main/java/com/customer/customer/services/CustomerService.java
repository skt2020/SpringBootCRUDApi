package com.customer.customer.services;

import java.util.List;

import com.customer.customer.entities.Customer;

public interface CustomerService {
	public  List<Customer> getCustomers();
	public Customer getCustomer(Long id);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(long id);
}
