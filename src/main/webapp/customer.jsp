<%@ page import="vn.edu.iuh.fit.labweek2.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.labweek2.services.CustomerService" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 01/12/2023
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
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
    List<Customer> list = new CustomerService().getAll();
%>
<div class="col-xs-12" style="height: 1090px; width: 960px; margin: auto;">
    <h4 style="text-align:center;">Danh sách Customer</h4>
    <table class="table table-striped" role="table">
        <form action="controls?action=insertCus" method="post">
            <tr>
                <th>ID</th>
                <th>Address</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th colspan="2"><a href="insertCustomer.jsp">Insert</a></th>
            </tr>
            <tbody>
            <%for (Customer customer : list) {%>
            <tr>

                <td><%=customer.getId()%>
                </td>
                <td><%=customer.getAddress()%>
                </td>
                <td><%=customer.getCustName()%>
                </td>
                <td><%=customer.getEmail()%>
                </td>
                <td><%=customer.getPhone()%>
                </td>
                <td><a href="updateCustomer.jsp?id=<%=customer.getId()%>">Update</a></td>
                <%--                <td><a href="controls?action=delete_emp&id=<%=customer.getId()%>">Delete</a></td>--%>
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
