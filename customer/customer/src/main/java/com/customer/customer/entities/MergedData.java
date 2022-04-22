package com.customer.customer.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class MergedData 
{
	@Autowired
	private RestTemplate restTemplate;
	private int id;
	private String name;
	private String email;
	private List<Product> products;
	

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> product) {
		this.products = product;
	}
	
	public MergedData(Customer customer) {
		super();
		this.id = customer.getId();
		this.name = customer.getName();
		this.email = customer.getEmail();
		restTemplate=new RestTemplate();
		products=new ArrayList<Product>();
		if(customer.getProductId1()!=0)
		{
			this.products.add(this.restTemplate.getForObject("http://localhost:8080/getProducts/"+customer.getProductId1(),Product.class));
		}
		if(customer.getProductId2()!=0)
		{
			this.products.add(this.restTemplate.getForObject("http://localhost:8080/getProducts/"+customer.getProductId2(),Product.class));
		}
		if(customer.getProductId3()!=0)
		{
			this.products.add(this.restTemplate.getForObject("http://localhost:8080/getProducts/"+customer.getProductId3(),Product.class));
		}
		if(customer.getProductId4()!=0)
		{
			this.products.add(this.restTemplate.getForObject("http://localhost:8080/getProducts/"+customer.getProductId4(),Product.class));
		}
	}
	public MergedData(Customer customer,List<Product> product) {
		super();
		this.id = customer.getId();
		this.name = customer.getName();
		this.email = customer.getEmail();
		this.products=product;
	}
	public MergedData(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public MergedData(int id, String name, String email, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.products = products;
	}
	public MergedData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + name + ", Email=" + email + ",products="+products+"]";
	}

}
