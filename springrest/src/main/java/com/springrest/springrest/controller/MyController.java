package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/getProducts")
	public List<Product> getProducts(){
		
		return this.productService.getAllProducts();
		
	}
	
	//get single product detail by Id
	@GetMapping("/getProducts/{productId}")
	public Product getProduct(@PathVariable String productId) {
		
		return this.productService.getProductById(Long.parseLong(productId));
	}
	
	// add new product
	@PostMapping(path="/addProduct",consumes="application/json")
	public Product addProduct(@RequestBody Product product) {
		
		return this.productService.addProduct(product);
		
	}
	 
	// Update existing product details
	@PostMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return this.productService.updateProduct(product);
	}
	
	//delete product details
	@PostMapping("/products/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId){
		try {
			this.productService.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}