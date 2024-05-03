package com.HL.model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.HL.model.Category;
import com.HL.model.Customer;
import com.HL.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBCrub {
   static PreparedStatement ps = null;
   static ResultSet rs = null;
   public List<Product> GetProduct(){
	   List<Product> productlist = new ArrayList<Product>();
	   String sql = "SELECT * FROM product";
	   try {
		   new Connection_SQL();
		   Connection conn = Connection_SQL.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   int id = rs.getInt("id");
			   String name = rs.getString("name");
			   double price = rs.getDouble("price");
			   String description = rs.getString("description");
			   String image = rs.getString("image");
			   Product product = new Product(id,name,price,description,image);
			   productlist.add(product);
		   }
	   }
	   catch(Exception e) {
           e.printStackTrace();
	   }
	   finally{
		   try {
			   ps.close();
			   rs.close();
		   }
		   catch(SQLException e1) {
	           e1.printStackTrace();
		   }
	   }
	   return productlist;  
   }
   public List<Product> getProductByName(String search){
		List<Product> listName = new ArrayList<>();
		String sql = "SELECT * FROM product where name like ?";
		try {
			  new Connection_SQL();	
		   Connection  conn = Connection_SQL.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, "%"+search+"%");
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   int id = rs.getInt("id");
			   String name = rs.getString("name");
				Double price = rs.getDouble("price");
             String description = rs.getString("description");
				String image = rs.getString("image");
				Product product = new Product(id,name,price,description,image);
				listName.add(product);
			}
		}
		catch(Exception e4) {
			e4.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			}
			catch(SQLException  e) {
				
			}
		}
		return listName;
				
	}
   public Boolean Login(String email,String pass ) {
	   Customer cus = null;
		String sql = "SELECT * FROM customer where email = ? and pass =?";
		try {
			  new Connection_SQL();	
		   Connection  conn = Connection_SQL.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   ps.setString(1,email);
		   ps.setString(2,pass);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			  
			   String email1 = rs.getString("email");		
			   String  pass1 = rs.getString("pass");   
			   
				cus = new Customer(email1,pass1);
				 return true;
			}
		}
		catch(Exception e4) {
			e4.printStackTrace();
			return false;
		}finally {
			try {
				ps.close();
				rs.close();
			}
			catch(SQLException  e) {
				
			}
		}
		return true;  
   }
   public Boolean SignUp(Customer customer ) {
		String sql = "insert into customer(cus_id,name,email,pass,phone) values(?,?,?,?,?)";
		try {
			  new Connection_SQL();	
		   Connection  conn = Connection_SQL.getMySQLConnection();
		      ps = conn.prepareStatement(sql);		   
			  ps.setInt(1,customer.getCus_id());
			  ps.setString(2,customer.getName());
			  ps.setString(3,customer.getEmail());		
			  ps.setString(4,customer.getPass());
			  ps.setString(5,customer.getPhone());			   
			  ps.executeUpdate();	
			
		}
		catch(Exception e4) {
			e4.printStackTrace();
		}
		return true;  
   }
   public List<Product> getProductCateID(int cate_id){
		List<Product> listCate = new ArrayList<>();
		String sql = "SELECT * FROM product where cate_id = ?";
		try {
			new Connection_SQL();
			Connection  conn = Connection_SQL.getMySQLConnection(); 
		    ps = conn.prepareStatement(sql);
		    ps.setInt(1,cate_id);
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	 int id = rs.getInt("id");
		    	  String name = rs.getString("name");
				  Double price = rs.getDouble("price");
	              String description = rs.getString("description");
	              String image = rs.getString("image");
	              Product product = new Product(id,name,price,description,image);
	    		  listCate.add(product);
		    }
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		 finally {
	            try {
	                ps.close();
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	        }
		return listCate;
		
	}
   public boolean UpdateCustomer(Customer customer, int id) {
	   String sql ="UPDATE customer SET name =?, email = ?, pass = ?, phone = ? where cus_id =?";
	   
	   try {
		   new Connection_SQL();
		   Connection  conn = Connection_SQL.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   ps.setInt(5, id);
		   ps.setString(1,customer.getName());
		   ps.setString(2,customer.getEmail());
		   ps.setString(3,customer.getPass());
		   ps.setString(4,customer.getPhone());
		   ps.executeUpdate();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return true;
   }
   public List<Category> getCategoryId()  {
		String sql = "SELECT * FROM category";
		List<Category> category = new ArrayList<>();
	
		try {
			new Connection_SQL();
			 Connection  conn = Connection_SQL.getMySQLConnection();
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("cid");
				String name = rs.getString("name");
			
				Category cate = new Category(id,name);
				category.add(cate);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();		
			}
		return category;
	}

//   // them san pham
//   public boolean InsertProduct(Product product) throws ClassNotFoundException{
//	   String sql = "CALL  AddProduct (?,?,?,?)";
//	   try {
//		   new Connection_SQL();	 
//		   Connection conn = Connection_SQL.getMySQLConnection();
//		   ps = conn.prepareStatement(sql);
//		   ps.setString(1, product.getName());
//		   ps.setDouble(2, product.getPrice());
//		   ps.setString(3, product.getDescription());
//		   ps.setString(4, product.getImage());
//		   ps.executeUpdate();
//		 }
//	   catch(Exception e) {
//		   e.printStackTrace();
//	   }
//		return true;
//
//   }
//   // update san pham
//   public boolean UpdateProduct(Product product, int id) {
//	   String sql ="CALL UpdateProduct( ?, ?, ?, ?)";
//	   
//	   try {
//		   new Connection_SQL();
//		   Connection  conn = Connection_SQL.getMySQLConnection();
//		   ps = conn.prepareStatement(sql);
//		   ps.setString(1,product.getName());
//		   ps.setDouble(2,product.getPrice());
//		   ps.setString(3,product.getDescription());
//		   ps.setString(4,product.getImage());
//		   ps.executeUpdate();
//	   }
//	   catch(Exception e) {
//		   e.printStackTrace();
//	   }
//	   return true;
//   }
//   public void DeleteProduct(int id) {
//	   String sql ="CALL DeleteProduct(?)";
//	   try {
//		   new Connection_SQL();
//		   Connection conn = Connection_SQL.getMySQLConnection();
//		   ps = conn.prepareStatement(sql);
//		   ps.setInt(1,id);
//		   ps.execute();
//	   }
//	   catch(Exception e) {
//		   e.printStackTrace();
//	   }
//   }
   public Product getProductById(int id)  {
		String sql = "SELECT * FROM product where id = ?";
		Product product = null;
	
		try {
			new Connection_SQL();
			 Connection  conn = Connection_SQL.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
               String description = rs.getString("description");
				String image = rs.getString("image");
				product = new Product(id,name,price,description,image);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();		
			}
		return product;
	}
   }
//
// }
