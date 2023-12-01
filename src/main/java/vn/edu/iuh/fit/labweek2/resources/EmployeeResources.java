package vn.edu.iuh.fit.labweek2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.labweek2.models.Employee;
import vn.edu.iuh.fit.labweek2.services.EmployeeServices;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    private EmployeeServices employeeServices;
    public EmployeeResources(){
        employeeServices = new EmployeeServices();
    }

    @GET
    @Path(("/{id}"))
    @Produces(value = "application/json")
    public Response getEmp(@PathParam("id") long eid){
        Optional<Employee> employee = employeeServices.findById(eid);
        if(employee.isPresent()){
            return Response.ok(employee).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Employee> list = employeeServices.getAll();
        return Response.ok(list).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee){
        employeeServices.insertEmp(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (employeeServices.delete(id)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
