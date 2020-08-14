<%-- 
    Document   : viewCart
    Created on : Jul 6, 2020, 8:16:24 PM
    Author     : ADMIN
--%>

<%@page import="huynm.books.BookDAO"%>
<%@page import="huynm.orderdetail.OderDetailDTO"%>
<%@page import="huynm.cart.CartDTO"%>
<%@page import="huynm.books.BookDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <h1>Your Cart : </h1>
        <%
            CartDTO list = (CartDTO) session.getAttribute("ORDER");
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    boolean checkFinsh = false;
                    BookDAO dao = new BookDAO();
                    for (OderDetailDTO dto : list.getCart().values()) {
                %>
            <form>
                <tr>
                    <td>
                        <%= count++%>
                    </td>
                    <td>
                        <input type="text" name="txtID" value="<%= dto.getBookID()%>" readonly="readonly" />
                    </td>
                    <td>
                        <input type="text" name="txtQuantity" value="<%= dto.getAmount()%>" readonly="readonly" />
                        <%
                            BookDTO book = dao.getBookByID(dto.getBookID());
                            if (book.getQuantity() >= dto.getAmount()) {
                                checkFinsh = true;
                            }
                        %>
                    </td>
                    <td>
                        <input type="submit" value="IncreaseCart" name="btnAction" />
                    </td>
                    <td>
                        <input type="submit" value="DecreaseCart" name="btnAction" />
                    </td>
                    <td>
                        <input type="submit" value="Delete Item" name="btnAction" />
                    </td>
                </tr>
            </form>
            <% }
            %>

            <form action="MainController">
                <%
                    if (checkFinsh) {
                %>
                <input type="submit" value="Finish" name="btnAction" />
                <%
                } else {%>
                <input type="submit" value="Finish" name="btnAction" disabled="disabled" />
                <%}
                %>

                <input type="text" name="txtReturnDate" value="" />
            </form>      
        </tbody>
    </table>    
    <%
        }
    %>
    <a href="search.jsp">Back To Shopping </a>
</body>
</html>
