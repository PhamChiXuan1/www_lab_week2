package vn.edu.iuh.fit.labweek2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.labweek2.models.Product;
import vn.edu.iuh.fit.labweek2.services.ProductService;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResource {
    private ProductService productService;
    public ProductResource(){
        productService = new ProductService();
    }

    @GET
    @Path(("/{id}"))
    @Produces(value = "application/json")
    public Response getProduct(@PathParam("id") long id){
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Product> list = productService.getAll();
        return Response.ok(list).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product){
        productService.insert(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if(productService.delete(id)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
