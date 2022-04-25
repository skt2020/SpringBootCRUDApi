package com.springrest.springrest.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.springrest.springrest.entities.Product;

public class CrudOp
{
	public static boolean addField(Product user)
    {
      String id = String.valueOf(user.getId());
      String name = user.getName();
      String desc = user.getDiscription();
      Connection con=Jdbc.getConnection();
      try
      {
    	   PreparedStatement pst=con.prepareStatement("insert into apidata values(?,?,?);");
           pst.setString(1, id);
           pst.setString(2, name);
           pst.setString(3, desc);
          
           int rs=pst.executeUpdate();
           if(rs == 0)
           {
               return true;
           }
           return false;
          
      }
      catch(SQLException e)
      {
            System.out.println(e);
      }
      return false;
        
    }
	
	public static Product getOneField(long id)
	{
		String ids=String.valueOf(id);
		Product p=null;
        try
        {
            Statement st = Jdbc.getStatement();
            String query = "Select * from apidata where id='"+ids+"';";
            System.out.println("Query = "+query);
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3));
                 p= new Product(rs.getInt(1),rs.getString(2),rs.getString(3));
                
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return p;
	}
	
	public static ArrayList<Product> getField()
	{
		ArrayList<Product> set=new ArrayList<Product>();
        try
        {
            Statement st = Jdbc.getStatement();
            String query = "Select * from apidata;";
            System.out.println("Query = "+query);
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3));
                 set.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3)));
                
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return set;
	}
	
	public static boolean isPresent(String id)
	{
		
        try
        {
            Statement st = Jdbc.getStatement();
            String query = "Select * from apidata where id='"+id+"';";
            System.out.println("Query = "+query);
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
            	 System.out.println("Result set true");
               return true;
                
            }
            System.out.println("Result set false");
            return false;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return false;
	}
	
	public static boolean updateField(Product user)
    {
      String id = String.valueOf(user.getId());
      String name = user.getName();
      String desc = user.getDiscription();
      Statement st=Jdbc.getStatement();
      if(isPresent(id))
      {
	      try
	      {
	    	  String query="UPDATE apidata SET name= '"+name+"', discription= '"+desc+"' WHERE id = '"+id+"';";
	    	   int rs=st.executeUpdate(query);
	           if(rs == 0)
	           {
	               return true;
	           }
	           return false;
	          
	      }
	      catch(SQLException e)
	      {
	            System.out.println(e);
	      }
      }
      System.out.println("\n not updated \n");
      return false;
    }
	
	public static boolean deleteField(long ids)
    {
      String id=String.valueOf(ids);
      Statement st=Jdbc.getStatement();
      if(isPresent(id))
      {
	      try
	      {
	    	  String query = "DELETE FROM apidata WHERE id ='"+id+"';";
	    	   int rs=st.executeUpdate(query);
	           if(rs == 1)
	           {
	               return true;
	           }
	           return false;
	          
	      }
	      catch(SQLException e)
	      {
	            System.out.println(e);
	      }
      }
      return false;
    }
}