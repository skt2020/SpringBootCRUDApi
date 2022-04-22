package com.customer.customer.services;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.customer.customer.entities.Customer;




public class CrudOperations
{
	static SessionFactory factory = null;
	 Session session = null;
	public CrudOperations()
	{
		factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
	}
	
	public  boolean addNewCustomer(Customer customer)
    {
      try
      { 
    	  session = factory.getCurrentSession();
    	  session.beginTransaction();
    	  
    	  session.save(customer);
    	  
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
	public  Customer getCustomerById(long customerId)
	{
		session=factory.getCurrentSession();
		session.beginTransaction();
        try
        {
        	List<Customer> customerList=session.createQuery("from Customer a where a.id='"+String.valueOf(customerId)+"'").list();
        	for(Customer customer: customerList)
        	{
        		return customer;
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
	public  ArrayList<Customer> getCustomerList()
	{
		session = factory.getCurrentSession();
		session.beginTransaction();

		ArrayList<Customer> customerList=new ArrayList<Customer>();
        try
        {
        	List<Customer> queryData = session.createQuery("from Customer").list();
			for (int i = 0; i < queryData.size(); i++) 
			{
				customerList.add(queryData.get(i));
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
        return customerList;
	}
	public  boolean updateCustomerDetails(Customer customer)
    {
      int customerId=customer.getId();
   
      Transaction tx=null;
      try
	  {
    	  
    	  session = factory.getCurrentSession();
    	  tx= session.beginTransaction();
    	  
    	  Customer sessionCustomer = session.get(Customer.class,customerId);
    	  if(sessionCustomer.equals("null"))
    	  {
    		  session.close();
    		  return false;
    	  }
    	  Query q=session.createQuery("update Customer set name=:n, email=:e, productid1=:p1, productid2=:p2, productid3=:p3, productid4=:p4  where id=:i");  
    	  q.setParameter("n",customer.getName());
    	  q.setParameter("e",customer.getEmail());
    	  q.setParameter("p1",customer.getProductId1());
    	  q.setParameter("p2",customer.getProductId2());
    	  q.setParameter("p3",customer.getProductId3());
    	  q.setParameter("p4",customer.getProductId4());
    	  q.setParameter("i",customerId);  
    	    
    	  int status=q.executeUpdate();  
    	  if(status!=1)
    	  {
    		  throw new Exception("Update in id = "+String.valueOf(customerId)+" failed, hence raised exception.");
    	  }
    	  tx.commit();
    	  
    	  session.close();
    	  return true;
      }
      catch(Exception e)
      {
    	  System.out.println(e);
    	  session.close();
    	  return false;
      }
    }
	
	public  boolean deleteCustomer(long customerId)
    {
     
      Transaction tx=null;
      try
      {
    	  
    	  session = factory.getCurrentSession();
    	  tx= session.beginTransaction();
    	  Customer sessionCustomer= session.get(Customer.class,(int)customerId);
    	  if(sessionCustomer.getId()!=customerId)
    	  {
    		  throw new Exception("Update in id = "+String.valueOf(customerId)+" failed, hence raised exception.");
    	  }
    	  session.delete(sessionCustomer);
    	  tx.commit();
    	  session.close();
    	  return false;
      }
      catch(Exception e)
      {
    	  System.out.println(e);
      }
      
      return false;
    }
}
