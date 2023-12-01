package vn.edu.iuh.fit.labweek2.modelsfe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.labweek2.enums.ProductStatus;
import vn.edu.iuh.fit.labweek2.models.Product;
import vn.edu.iuh.fit.labweek2.services.ProductService;

import java.io.IOException;

public class ProductModel {
    private final ProductService productService = new ProductService();
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String des = request.getParameter("description");
        String mn = request.getParameter("mn");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        Product product = new Product(des, mn, name, ProductStatus.ACTIVE, unit);
        productService.insert(product);
        response.sendRedirect("product.jsp");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception{
        long id = Long.parseLong(request.getParameter("id"));
        String des = request.getParameter("description");
        String mn = request.getParameter("mn");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        Product product = new Product(id, des, mn, name, ProductStatus.ACTIVE, unit);
        productService.update(product);
        response.sendRedirect("product.jsp");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
        long id = Long.parseLong(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("product.jsp");
    }
}
