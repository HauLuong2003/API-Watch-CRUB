package com.HL.ResfulService;

import com.HL.model.Customer;
import com.HL.model.Connection.DBCrub;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.PUT;

@Path("/user")
public class LoginService {
	@Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("email") String email,@QueryParam("pass")String pass) {
        DBCrub db = new DBCrub();
        boolean loginSuccessful = db.Login(email,pass);
        if (loginSuccessful) {
            return Response.ok().entity("thanh cong").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("thất bại").build();
        }
    }
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SignUp(Customer cus ) {
        DBCrub db = new DBCrub();
        boolean loginSuccessful = db.SignUp(cus);
        if (loginSuccessful) {
            return Response.ok().entity("thanh cong").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("thất bại").build();
        }
		
	}
	@PUT
	@Path("/{id}/update-infor")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateProfile(Customer cus,@PathParam("id") int id ) {
        DBCrub db = new DBCrub();
        boolean update = db.UpdateCustomer(cus,id);
        if (update) {
            return Response.ok().entity("thanh cong").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("thất bại").build();
        }
		
	}
	
}
