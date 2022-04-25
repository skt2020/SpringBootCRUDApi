package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Product;

@Service
public class ProductServiceImplimentation implements ProductService {


	List<Product> list;
	CrudOperations crud;
	
	public ProductServiceImplimentation() {
	 crud=new CrudOperations();
	 
	}
	
	
	@Override
	public  ArrayList<Product> getAllProducts()
    {
       return crud.getProductList();
  }
	@Override
	public Product getProductById(long productId) {
		// TODO Auto-generated method stub
		return crud.getProductById(productId);
	}
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		crud.addNewProduct(product);
		return product;
	}
	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		crud.updateProductDetails(product);
		return product;
	}
	@Override
	public void deleteProduct(long productId) {
		// TODO Auto-generated method stub
		crud.deleteProduct(productId);
		
	}

}
