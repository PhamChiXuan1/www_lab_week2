<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 01/12/2023
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.labweek2.models.Employee" %>
<%@ page import="vn.edu.iuh.fit.labweek2.services.EmployeeServices" %>
<%@ page import="vn.edu.iuh.fit.labweek2.models.Product" %>
<%@ page import="vn.edu.iuh.fit.labweek2.services.ProductService" %>
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

</body>
</html>
