package com.HL.model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

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
   // them san pham
   public boolean InsertProduct(Product product) throws ClassNotFoundException{
	   String sql = "insert into product(id,name,price,description,image) values(?,?,?,?,?)";
	   try {
		   new Connection_SQL();	 
		   Connection conn = Connection_SQL.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, product.getId());
		   ps.setString(2, product.getName());
		   ps.setDouble(3, product.getPrice());
		   ps.setString(4, product.getDescription());
		   ps.setString(5, product.getImage());
		   ps.executeUpdate();
		 }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
		return true;

   }
   // update san pham
   public boolean UpdateProduct(Product product, int id) {
	   String sql ="UPDATE product SET name =?, price = ?, description = ?, image = ? where id =?";
	   
	   try {
		   new Connection_SQL();
		   Connection  conn = Connection_SQL.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   ps.setInt(5, id);
		   ps.setString(1,product.getName());
		   ps.setDouble(2,product.getPrice());
		   ps.setString(3,product.getDescription());
		   ps.setString(4,product.getImage());
		   ps.executeUpdate();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return true;
   }
   public void DeleteProduct(int id) {
	   String sql ="DELETE FROM product where id =?";
	   try {
		   new Connection_SQL();
		   Connection conn = Connection_SQL.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1,id);
		   ps.execute();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   public Product getProductById(int id) throws ClassNotFoundException {
		String url, user, password;
		Connection conn = null;
		String sql;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Product product = null;
		// connect to DB
		url = "jdbc:mysql://localhost:3306/watch_db";
		user = "root";
		password = "09012003";
		sql = "select * from product where id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
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
