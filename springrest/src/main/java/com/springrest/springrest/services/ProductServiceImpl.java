package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.ProductDao;
import com.springrest.springrest.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired
private ProductDao productDao;
//	List<Product> list;
	
	public ProductServiceImpl() {
//	  list = new ArrayList<>();
//	  list.add(new Product(124,"Tata Punch","Tata Punch price starts at ₹ 5.68 Lakh and goes upto ₹ 9.49 Lakh (Avg. ex-showroom). Punch comes in 18 variants."));
//	  list.add(new Product(291,"Tata Nexon","The price of Tata Nexon starts at Rs. 7.42 Lakh and goes upto Rs. 13.73 Lakh. Tata Nexon is offered in 65 variants - the base model of Nexon is XE and the top variant Tata Nexon XZA Plus P Dark Edition AMT Diesel which comes at a price tag of Rs. 13.73 Lakh"));
//	  list.add(new Product(372,"Tata Harrier","Tata Harrier price starts at ₹ 14.52 Lakh and goes upto ₹ 21.81 Lakh (Avg. ex-showroom). Harrier comes in 23 variants. The price of Harrier diesel base version is ₹ 14.52 Lakh. Whereas the price of Harrier automatic version starts from ₹ 17.22 Lakh."));
//	  list.add(new Product(481,"Tata Altroz","The price of Tata Altroz starts at Rs. 5.99 Lakh and goes upto Rs. 9.99 Lakh. Tata Altroz is offered in 31 variants - the base model of Altroz is XE and the top variant Tata Altroz XZ Plus Dark Edition Diesel which comes at a price tag of Rs. 9.99 Lakh."));
//	  list.add(new Product(652,"Tata Tiago","The price of Tata Tiago starts at Rs. 5.22 Lakh and goes upto Rs. 7.67 Lakh. Tata Tiago is offered in 16 variants - the base model of Tiago is XE and the top variant Tata Tiago XZ Plus Dual Tone Roof CNG which comes at a price tag of Rs. 7.67 Lakh."));
	}
	
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}


	@Override
	public Product getProduct(long productId) {
		// TODO Auto-generated method stub
//		Product p=null;
//		for(Product product:list) {
//			if(product.getId()==productId) {
//				p=product;
//				break;
//			}
//		}
		return productDao.getOne(productId);
	}


	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
//		list.add(product);
		productDao.save(product);
		return product;
	}


	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getId()==product.getId()) {
//				e.setName(product.getName());
//				e.setDiscription(product.getDiscription());
//			}
//		});
		productDao.save(product);
		return product;
	}


	@Override
	public void deleteProduct(long parseLong) {
		// TODO Auto-generated method stub
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Product entity=productDao.getOne(parseLong);
		productDao.delete(entity);
	}

}
