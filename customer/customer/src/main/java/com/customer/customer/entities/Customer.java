package com.customer.customer.entities;


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
@Column(name="productId")
private String productId;


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
public String getProductId()
{
	return productId;
}
public void setProductId(String productId)
{
	this.productId=productId;
}



@Override
public String toString() {
	return "Product [id=" + id + ", Name=" + name + ", Email=" + email + "]";
}
}
