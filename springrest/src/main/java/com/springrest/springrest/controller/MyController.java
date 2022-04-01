package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable String productId) {
		
		return this.productService.getProduct(Long.parseLong(productId));
	}
	
	// post  the product details
	@PostMapping(path="/products",consumes="application/json")
	public Product addProduct(@RequestBody Product product) {
		
		return this.productService.addProduct(product);
		
	}
	
	// Update product details
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return this.productService.updateProduct(product);
	}
	
	//delete product details
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId){
		try {
			this.productService.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
