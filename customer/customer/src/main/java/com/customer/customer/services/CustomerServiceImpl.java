package com.customer.customer.services;

import com.customer.customer.entities.Customer;
import com.customer.customer.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	List<Customer> list;
	public CustomerServiceImpl() {
		
		// dummey data
		list = new ArrayList<>();
		
		List<Product> product1;
		product1= new ArrayList<>();
		product1.add(new Product(124,"",""));
		product1.add(new Product(291,"",""));
		product1.add(new Product(372,"",""));
		
		List<Product> product2;
		product2= new ArrayList<>();
		product2.add(new Product(124,"",""));
		product2.add(new Product(481,"",""));
		product2.add(new Product(652,"",""));

		list.add(new Customer(1111,"Suryansh","suryanshtrivedi1@gmail.com",product1));
		list.add(new Customer(2222,"Aman","aman@gmail.com",product2));
		list.add(new Customer(3333,"Raj","raj@gmail.com"));
	}
	
	
	
	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		
		Customer c=null;
		for(Customer customer:list) {
			if(customer.getId()==id) {
				c=customer;
				break;
			}
		}
		return c;
	}



	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		list.add(customer);
		
		return customer;
	}



	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		list.forEach(e->{
			if(e.getId()==customer.getId()) {
				e.setName(customer.getName());
				e.setEmail(customer.getEmail());
				e.setProducts(customer.getProducts());
			}
		});
		return customer;
	}



	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		
	}



	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return list;
	}

}
