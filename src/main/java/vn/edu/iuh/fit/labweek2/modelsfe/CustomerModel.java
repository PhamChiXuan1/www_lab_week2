package vn.edu.iuh.fit.labweek2.modelsfe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.labweek2.models.Customer;
import vn.edu.iuh.fit.labweek2.services.CustomerService;

import java.io.IOException;

public class CustomerModel {
    private final CustomerService service = new CustomerService();
    public void insertCus(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException{
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Customer customer = new Customer(address, name, email, phone);

        service.insertCust(customer);
        response.sendRedirect("customer.jsp");
    }

    public void updataCus(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException{
        long id = Long.parseLong(request.getParameter("id"));
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Customer customer = new Customer(address, name, email, phone);

        service.updateCust(customer);
        response.sendRedirect("customer.jsp");
    }
}
