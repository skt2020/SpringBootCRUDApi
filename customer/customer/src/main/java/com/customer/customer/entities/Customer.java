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

public int getProductId1() {
	return productId1;
}

public void setProductId1(int productId) {
	this.productId1 = productId;
}
public int getProductId2() {
	return productId2;
}

public void setProductId2(int productId) {
	this.productId2 = productId;
}
public int getProductId3() {
	return productId3;
}

public void setProductId3(int productId) {
	this.productId3 = productId;
}
public int getProductId4() {
	return productId4;
}

public void setProductId4(int productId) {
	this.productId4 = productId;
}

@Override
public String toString() {
	return "Product [id=" + id + ", Name=" + name + ", Email=" + email + "]";
}
}
