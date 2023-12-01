package vn.edu.iuh.fit.labweek2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.labweek2.modelsfe.CustomerModel;
import vn.edu.iuh.fit.labweek2.modelsfe.EmployeeModel;
import vn.edu.iuh.fit.labweek2.modelsfe.ProductModel;

import java.io.IOException;

@WebServlet("/controls")
public class ServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if(actionObject!=null){
                String action = actionObject.toString();
                if(action.equals("insertEmp")){
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.insertEmp(req, resp);
                }else if (action.equals("insertCus")){
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.insertCus(req, resp);
                }else if (action.equals("update_emp")){
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.update(req, resp);
                }else if (action.equals("updateCus")){
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.updataCus(req, resp);
                }else if (action.equals("insertProduct")){
                    ProductModel productModel = new ProductModel();
                    productModel.insert(req, resp);
                }else if (action.equals("updateProduct")){
                    ProductModel productModel = new ProductModel();
                    productModel.update(req, resp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if(actionObject!=null){
                String action = actionObject.toString();
                if(action.equals("emp_list")){
                    resp.sendRedirect("employee.jsp");
                }else if (action.equals("cus_list")){
                    resp.sendRedirect("customer.jsp");
                }else if (action.equals("product_list")){
                    resp.sendRedirect("product.jsp");
                }else if (action.equals("delete_emp")){
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.delete(req, resp);
                }else if (action.equals("delete_product")){
                    ProductModel productModel = new ProductModel();
                    productModel.delete(req, resp);
                }else if (action.equals("order_list")){
                    resp.sendRedirect("order.jsp");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
