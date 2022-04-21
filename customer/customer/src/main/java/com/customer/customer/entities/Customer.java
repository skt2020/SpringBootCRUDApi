package com.customer.customer.entities;

import java.util.ArrayList;

import java.util.List;

public class Customer {


private int id;
private String name;
private String email;

private List<Product> products= new ArrayList<>();

public Customer(int id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}

public Customer(int id, String name, String email, List<Product> products) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.products = products;
}

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

}
