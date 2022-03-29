package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Product;
import com.springrest.springrest.services.ProductService;
import java.util.List;

@CrossOrigin
@RestController
public class MyController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String home() {
		return "API is working";
	}
	
	// get  the product details
	@GetMapping("/products")
	public List<Product> getProducts(){
		
		return this.productService.getProducts();
		
	}
	
	
}
