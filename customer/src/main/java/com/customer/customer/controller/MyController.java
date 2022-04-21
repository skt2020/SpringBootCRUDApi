package com.customer.customer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		return this.customerService.getCustomers();
		
	}
	
	@GetMapping("/getcustomer/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") long customerId) {
		//Logic of adding records from product microservice
		return this.customerService.getCustomer(customerId);
		
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
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String customerId){
		try {
			this.customerService.deleteCustomer(Long.parseLong(customerId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
