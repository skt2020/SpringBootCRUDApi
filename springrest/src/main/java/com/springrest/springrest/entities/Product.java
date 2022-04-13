package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private long id;
	private String Name;
	private String Discription;
	public Product(long id, String name, String discription) {
		super();
		this.id = id;
		Name = name;
		Discription = discription;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + Name + ", Discription=" + Discription + "]";
	}
	

}
