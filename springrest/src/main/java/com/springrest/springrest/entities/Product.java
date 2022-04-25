package com.springrest.springrest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String Name;
	@Column(name="discription")
	private String Discription;
	public Product(int id, String name, String discription) {
		super();
		this.id = id;
		Name = name;
		Discription = discription;
	}
	public Product() {
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
