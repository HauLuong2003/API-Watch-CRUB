package com.HL.ResfulService;

import java.util.List;

import com.HL.model.Category;
import com.HL.model.Product;
import com.HL.model.Connection.DBCrub;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


public class APIService {
	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> GetProductByName(@QueryParam("search")String search){
		DBCrub dbCrub = new DBCrub();
		List<Product> catelist = dbCrub.getProductByName(search);
		return catelist;
	}
	@GET
	@Path("/category")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> GetCategory(){
		DBCrub dbCrub = new DBCrub();
		List<Category> catelist = dbCrub.getCategoryId();
		return catelist;
	}
}
