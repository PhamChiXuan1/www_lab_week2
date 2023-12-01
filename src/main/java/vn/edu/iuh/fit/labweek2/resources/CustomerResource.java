package vn.edu.iuh.fit.labweek2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.labweek2.models.Customer;
import vn.edu.iuh.fit.labweek2.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Path("/customers")
public class CustomerResource {
    private CustomerService customerService;
    public CustomerResource(){
        customerService = new CustomerService();
    }
    @GET
    @Path(("/id"))
    @Produces(value = "application/json")
    public Response getCust(@PathParam("id") long cid){
        Optional<Customer> customer = customerService.findById(cid);
        if(customer.isPresent()){
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer){
        customerService.insertCust(customer);
        return Response.ok(customer).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Customer> list = customerService.getAll();
        return Response.ok(list).build();
    }
}
