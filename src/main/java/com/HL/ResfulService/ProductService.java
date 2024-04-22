package com.HL.ResfulService;

import java.util.List;

import com.HL.model.Customer;
import com.HL.model.Product;
import com.HL.model.Connection.DBCrub;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/products")
public class ProductService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> GetProduct(){
		DBCrub dbCrub = new DBCrub();
		List<Product> productlist = dbCrub.GetProduct();
		return productlist;
	}

	@GET
	@Path("/category/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductCateID(@PathParam("id")int id){
		DBCrub dbCrub = new DBCrub();
		List<Product> catelist = dbCrub.getProductCateID(id);
		return catelist;
	}
	
	
	
	/*
    // Phương thức DELETE để xóa một sản phẩm dựa trên ID
	@DELETE
	@Path("/{id}")
	public void deleteProduct(@PathParam("id") int id) {
        DBCrub dbCrub = new DBCrub();
         dbCrub.DeleteProduct(id);	  
    }
	// phuong thuc them san pham
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response InsertProduct(Product product) throws ClassNotFoundException {
		DBCrub dbCrub = new DBCrub();
		 boolean inserted = dbCrub.InsertProduct(product);		
		 if(inserted) {
		        return Response.status(Response.Status.OK).entity("thêm thành công").build();
			}
			else {
				return Response.status(Response.Status.NOT_FOUND).entity("thất bại").build();
			}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateProduct( Product product,@PathParam("id") int id) {
		 DBCrub dbCrub = new DBCrub();
		 boolean updated =  dbCrub.UpdateProduct(product, id);
		 if(updated) {
		        return Response.status(Response.Status.OK).entity("sửa thành công").build();
			}
			else {
				return Response.status(Response.Status.NOT_FOUND).entity("thất bại").build();
			}
	}
	*/
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById_JSON(@PathParam("id") int id) throws ClassNotFoundException {
		DBCrub product = new DBCrub();
		Product getById = product.getProductById(id);
		return Response.status(Response.Status.OK).entity(getById).build();
	}
}
