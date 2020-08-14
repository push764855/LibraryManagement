<%-- 
    Document   : vieworder
    Created on : Jul 15, 2020, 10:41:31 AM
    Author     : ADMIN
--%>

<%@page import="huynm.orderdetail.OderDetailDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order</title>
    </head>
    <body>
        <h1>Your <%= session.getAttribute("USER_ID_SEARCH")%> Orders: </h1>
        <%
            List<OderDetailDTO> list = (List<OderDetailDTO>) session.getAttribute("LIST_ORDERED");
            if (list != null) {
        %>
        <form action="MainController">
            <input type="text" name="txtFindOrderByBookID" value="" />
            <input type="submit" value="Find" name ="btnAction" /><br/>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Book ID</th>
                    <th>ID</th>
                    <th>Order ID</th>
                    <th>Take</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (OderDetailDTO dto : list) {
                %>
                <tr>
                    <td>
                        <%= count++%>
                    </td>
                    <td>
                        <%= dto.getBookID()%> 
                    </td>
                    <td>
                        <%= dto.getAmount()%> 
                    </td>
                    <td>
                        <%= dto.getOrderID()%> 
                    </td>
                    <td>
                        <form action="MainController">
                            <input type="submit" value="Take" name="btnAction"/>
                            <input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>" />
                            <input type="hidden" name="txtAmount" value="<%= dto.getAmount() %>" />            
                            <input type="hidden" name="txtOrderID" value="<%= dto.getOrderID() %>" />            
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <% } else {
        %>
        <h1>No record matched</h1>
        <%
            }%>
    </body>
</html>
