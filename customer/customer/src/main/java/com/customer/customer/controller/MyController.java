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
import com.customer.customer.entities.MergedData;
import com.customer.customer.services.CustomerService;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class MyController {
	
	@GetMapping("/")
	public String home() {
		return "Customer API is working";
		
	}
	
	@Autowired
	private CustomerService customerService;
	private RestTemplate restTemplate;
	

	
	@GetMapping("/customers")
	public List<MergedData> getProducts(){
		//Logic of adding records from product microservice
		List<Customer> customer=this.customerService.getCustomers();
		List<MergedData> mergedData=new ArrayList<MergedData>();
		customer.forEach(e->{
			mergedData.add(new MergedData(e));
		});
		return mergedData;
	}
	
	@GetMapping("/getcustomer/{customerId}")
	public MergedData getCustomer(@PathVariable("customerId") long customerId) {
		//Logic of adding records from product microservice
		MergedData customer=new MergedData(this.customerService.getCustomer(customerId));
		List<Product> product2;
		restTemplate=new RestTemplate();
		product2= new ArrayList<>();
		//http://localhost:8081/products/124
		
		int productListSize=customer.getProducts().size();
		for(int i=0;i<productListSize;i++)
		{
			 long productId= customer.getProducts().get(i).getId();
			 product2.add(this.restTemplate.getForObject("http://localhost:8080/getProducts/"+productId,Product.class));
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
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String customerId){
		try {
			this.customerService.deleteCustomer(Long.parseLong(customerId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
