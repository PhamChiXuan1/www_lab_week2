<%@ page import="vn.edu.iuh.fit.labweek2.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.labweek2.services.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 01/12/2023
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <%@include file="css.jsp" %>
    <div class="container">
        <div class="col-xs-12">
            <nav class="navbar navbar-expand-sm">
                <ul class="navbar nav">

                    <li class="navbar-item"><a href="controls?action=emp_list" class="navbar-link"
                                               style="margin-right: 20px; color: black; text-decoration: none"
                                               id="btn1">Employee</a>
                    </li>
                    <li class="navbar-item"><a href="controls?action=p_list" class="navbar-link" id="btn2"
                                               style="margin-right: 20px; color: black; text-decoration: none">Product</a>
                    </li>
                    <li class="navbar-item"><a href="controls?action=cus_list" class="navbar-link" id="btn4"
                                               style="margin-right: 20px; color: black; text-decoration: none">
                        Customer</a>
                    </li>

                    <li class="navbar-item"><a href="controls?action=order_list" class="navbar-link" id="btn5"
                                               style="margin-right: 20px; color: black; text-decoration: none">
                        Order</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</head>
<body>
<%
    //  List<Employee> list = (List<Employee>) session.getAttribute("emp_list");
//    List<Employee> list = (List<Employee>) request.getAttribute("emp_list");
    List<Product> list = new ProductService().getAll();
%>
<div class="col-xs-12" style="height: 1090px; width: 960px; margin: auto;">
    <h4 style="text-align:center;">Danh sách Product</h4>
    <table class="table table-striped" role="table">
        <form action="controls?action=insertP" method="post">
            <tr>
                <th>ID</th>
                <th>Description</th>
                <th>Manufacturer Name</th>
                <th>Name</th>
                <th>Status</th>
                <th>Unit</th>
                <th><a href="insertProduct.jsp">Insert</a></th>
                <th><a href="productPrice.jsp">ProductPrice</a></th>
            </tr>
            <tbody>
            <%for (Product product : list) {%>
            <tr>
                <td><%=product.getId()%>
                </td>
                <td><%=product.getDescription()%>
                </td>
                <td><%=product.getManufacturerName()%>
                </td>
                <td><%=product.getName()%>
                </td>
                <td><%=product.getStatus()%>
                </td>
                <td><%=product.getUnit()%>
                </td>
                <td><a href="updateProduct.jsp?id=<%=product.getId()%>">Update</a></td>
                <td><a href="controls?action=delete_p&id=<%=product.getId()%>">Delete</a></td>
                <%
                    }
                %>
            </tr>

            </tbody>


        </form>
    </table>
</div>
</body>
</html>
