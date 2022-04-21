package com.customer.customer.entities;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
@Id
@Column(name="id")
private int id;
@Column(name="name")
private String name;
@Column(name="email")
private String email;
@Column(name="productId1")
private int productId1;
@Column(name="productId2")
private int productId2;
@Column(name="productId3")
private int productId3;
@Column(name="productId4")
private int productId4;
private List<Product> products= new ArrayList<>();

public Customer(int id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}
/*
public Customer(int id, String name, String email, List<Product> products) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.products = products;
}*/

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
