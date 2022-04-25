package com.springrest.springrest.services;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.springrest.springrest.entities.Product;

public class CrudOperations
{
	static SessionFactory factory = null;
	 Session session = null;
	public CrudOperations()
	{
		factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
	}
	public  boolean addNewProduct(Product product)
    {
      try
      { 
    	  session = factory.getCurrentSession();
    	  session.beginTransaction();
    	  
    	  session.save(product);
    	  
    	  session.getTransaction().commit();
    	  session.close();
    	  return true;
      }
      catch(Exception e)
      {
            System.out.println(e);
            session.close();
      }
      return false;
        
    }
	
	public  Product getProductById(long productId)
	{
		session=factory.getCurrentSession();
		session.beginTransaction();
        try
        {
        	List<Product> productList=session.createQuery("from Product a where a.id='"+String.valueOf(productId)+"'").list();
        	for(Product product: productList)
        	{
        		return product;
        	}
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
		{
			session.close();
		}
        return null;
	}
	
	public  ArrayList<Product> getProductList()
	{
		session = factory.getCurrentSession();
		session.beginTransaction();

		ArrayList<Product> productList=new ArrayList<Product>();
        try
        {
        	List<Product> queryData = session.createQuery("from Product").list();
			for (int i = 0; i < queryData.size(); i++) 
			{
				productList.add(queryData.get(i));
			}
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
		{
			session.close();
		}
        return productList;
	}
	/*
	public  boolean isPresent(String id)
	{
		
		try
		{
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Product> pd = session.createQuery("from Product").list();
			session.close();
			if(pd.isEmpty())
				return false;
			else
				return true;
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
			session.close();
		}
		
        return false;
	}
	*/
	public  boolean updateProductDetails(Product product)
    {
      int productId=product.getId();
   
      Transaction tx=null;
      try
	  {
    	  
    	  session = factory.getCurrentSession();
    	  tx= session.beginTransaction();
    	  
    	  Product sessionProduct = session.get(Product.class,productId);
    	  if(sessionProduct.equals("null"))
    	  {
    		  session.close();
    		  return false;
    	  }
    	  Query q=session.createQuery("update Product set name=:n, discription=:d  where id=:i");  
    	  q.setParameter("n",product.getName());
    	  q.setParameter("d",product.getDiscription());
    	  q.setParameter("i",productId);  
    	    
    	  int status=q.executeUpdate();  
    	  if(status!=1)
    	  {
    		  throw new ProjectException("Update in id = "+String.valueOf(productId)+" failed, hence raised exception.");
    	  }
    	  tx.commit();
    	  
    	  session.close();
    	  return true;
      }
      catch(ProjectException e)
      {
    	  System.out.println(e);
    	  session.close();
    	  return false;
      }
      catch(Exception e)
      {
    	  System.out.println(e);
    	  session.close();
    	  return false;
      }
      return false;
    }
	
	public  boolean deleteProduct(long productId)
    {
     
      Transaction tx=null;
      try
      {
    	  
    	  session = factory.getCurrentSession();
    	  tx= session.beginTransaction();
    	  Product sessionProduct= session.get(Product.class,(int)productId);
    	  if(sessionProduct.getId()!=productId)
    	  {
    		  throw new ProductException("Update in id = "+String.valueOf(productId)+" failed, hence raised exception.");
    	  }
    	  session.delete(sessionProduct);
    	  tx.commit();
    	  session.close();
    	  return false;
      }
      catch(ProductException e)
      {
    	  System.out.println(e);
      }
      
      return false;
    }
}