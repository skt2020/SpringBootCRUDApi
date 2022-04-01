package com.springrest.springrest.services;

import java.util.ArrayList;
import com.springrest.springrest.entities.Product;

public interface ProductService {
	
	public  ArrayList<Product> getProducts();
	public Product getProduct(long productId);
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(long parseLong);
}
