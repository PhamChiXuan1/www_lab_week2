package vn.edu.iuh.fit.labweek2.modelsfe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.labweek2.enums.EmployeeStatus;
import vn.edu.iuh.fit.labweek2.models.Employee;
import vn.edu.iuh.fit.labweek2.services.EmployeeServices;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeModel {
    private final EmployeeServices services = new EmployeeServices();
    public void insertEmp(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedIOException{
        String name = request.getParameter("name");
        String sdob = request.getParameter("dob");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(sdob, df);
        Employee employee = new Employee(name, dob, email, address, phone, EmployeeStatus.ACTIVE);
        services.insertEmp(employee);
        response.sendRedirect("employee.jsp");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
        long id = Long.parseLong(request.getParameter("id"));
        services.delete(id);
        response.sendRedirect("employee.jsp");
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception{
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String sdob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(sdob, df);
        Employee employee = new Employee(id, name, dob, email, address, phone, EmployeeStatus.ACTIVE);
        services.update(employee);
        response.sendRedirect("employee.jsp");
    }
}
