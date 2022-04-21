package com.customer.customer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.customer.entities.Product;
import com.customer.customer.entities.Customer;
import com.customer.customer.services.CustomerService;


@CrossOrigin
@RestController
public class MyController {
	@GetMapping("/")
	public String home() {
		return "Customer API is working";
		
	}
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/customers")
	public List<Customer> getProducts(){
		//Logic of adding records from product microservice
		List<Customer> customer=this.customerService.getCustomers();

		//http://localhost:8081/products/124
		
		customer.forEach(e->{
			List<Product> product1;
			product1= new ArrayList<>();
			int productListSize=e.getProducts().size();
			for(int i=0;i<productListSize;i++)
			{
				 long productId= e.getProducts().get(i).getId();
				 product1.add(this.restTemplate.getForObject("http://localhost:8081/products/"+productId,Product.class));
			}
			e.setProducts(product1);
			
		});
		
		 //customer.setProducts(product1);
		
		
		
		//return this.customerService.getCustomers();
		return customer;
		
	}
	
	@GetMapping("/getcustomer/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") Long id) {
		//Logic of adding records from product microservice
		Customer customer=this.customerService.getCustomer(id);
		List<Product> product2;
		product2= new ArrayList<>();
		//http://localhost:8081/products/124
		
		int productListSize=customer.getProducts().size();
		for(int i=0;i<productListSize;i++)
		{
			 long productId= customer.getProducts().get(i).getId();
			 product2.add(this.restTemplate.getForObject("http://localhost:8081/products/"+productId,Product.class));
		}
		

		/*
		
		Product p =	this.restTemplate.getForObject("http://localhost:8081/products/124",Product.class);
		product2.add(p);
		
		Product p1 =	this.restTemplate.getForObject("http://localhost:8081/products/291",Product.class);
		product2.add(p1);
		*/
		
	    customer.setProducts(product2);
		//return this.customerService.getCustomer(id);
		return customer;
		
	}
	
	@PostMapping(path="/addcustomer",consumes="application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return this.customerService.addCustomer(customer);
		
	}
	
	@PostMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return this.customerService.updateCustomer(customer);
	}
	
	@PostMapping("/deletecustomer/{customerId}")
	public void deleteCustomer(@PathVariable String customerId){
		this.customerService.deleteCustomer(Long.parseLong(customerId));
			
	}

}
