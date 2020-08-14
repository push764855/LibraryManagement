<%-- 
    Document   : search
    Created on : Jun 30, 2020, 7:47:02 PM
    Author     : ADMIN
--%>

<%@page import="huynm.orderdetail.OderDetailDTO"%>
<%@page import="huynm.books.BookDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Searching Page</title>
    </head>
    <body>
        <form action="MainController" >
            <%
                String fullName = (String) session.getAttribute("FULL_NAME");
                int roleID = (int) session.getAttribute("ROLE_ID");
                String searchValue = request.getParameter("txtSearchValue");
                if (searchValue == null) {
                    searchValue = "";
                }
            %>

            <h3> Welcome <%= fullName%></h3>
            <a href="MainController?btnAction=Log Out">Log Out</a><br/>
            <input type="text" name="txtSearchValue" value="<%= searchValue%>" />
            <input type="submit" value="Search" name="btnAction" />

            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Book Name</th>
                        <th>Book Quantity</th>
                        <th>Book Description</th>
                        <th>Prices</th>
                            <%
                                if (roleID != 1) {
                            %>
                        <th>Add To Cart</th>
                            <%
                                }
                            %>

                        <%
                            if (roleID == 1) {
                        %>
                        <th>Delete</th>   
                        <th>Update</th>   
                            <%
                                }

                            %>
                    </tr>
                </thead>
                <tbody>
                    <%                        List<BookDTO> list = (List<BookDTO>) session.getAttribute("LIST_BOOK");
                        int count = 1;
                        if (list != null) {
                            for (BookDTO dto : list) {
                    %>            
                    <tr>
                        <td>
                            <%= count++%>
                            <input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>" />
                        </td>
                        <td>
                            <input type="text" name="txtBookName" value="<%= dto.getBookName()%>" readonly="readonly" />
                        </td>
                        <td>

                            <input type="text" name="txtBookQuantity" value="<%= dto.getQuantity()%>" readonly="readonly" />
                        </td>
                        <td>

                            <input type="text" name="txtBookDes" value="<%= dto.getBookDescription()%>" readonly="readonly" />
                        </td>
                        <td>
                            <input type="text" name="txtPrices" value="<%= dto.getPrices()%>" readonly="readonly" />             
                        </td>

                        <%
                            if (roleID != 1) {
                        %>
                        <td>
                            <%
                                if (dto.isShowCart()) {
                            %>
                            <form action="MainController">
                                <input type="submit" value="Add To Cart" name="btnAction"/>
                                <input type="hidden" name="txtBookName" value="<%= dto.getBookName()%>" />
                                <input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>" />            
                            </form>
                            <%
                            } else {
                            %>
                            <input type = "submit" value = "Add To Cart" name = "btnAction" disabled= "disabled" />
                            <%
                                }
                            %>
                        </td>
                        <%
                        } else {
                        %>
                        <td>
                            <a href="MainController?btnAction=Delete&txtSearchValue=<%= searchValue%>&txtBookID=<%= dto.getBookID()%>">Delete</a>
                        </td>
                        <td>
                            <form action="MainController">
                                <input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>" />
                                <input type="hidden" name="txtBookName" value="<%= dto.getBookName()%>" />
                                <input type="hidden" name="txtBookQuantity" value="<%= dto.getQuantity()%>" />
                                <input type="hidden" name="txtBookDes" value="<%= dto.getBookDescription()%>" />
                                <input type="hidden" name="txtPrices" value="<%= dto.getPrices()%>" />
                                <input type="hidden" name="txtSearchValue" value=" <%= searchValue%>" />
                                <input type="submit" value="Update Book" name="btnAction" />
                            </form>

                        </td>


                        <%
                            }
                        %>

                    </tr>
                    <%
                            }
                        }
                        if (roleID == 1) {
                    %>
                <form action="MainController">
                    <input type="text" name="txtSearchByID" value="" />
                    <input type="submit" value="Return Book" name="btnAction" />
                    <input type="submit" value="Insert New Book" name="btnAction" />
                </form>
                <%} else {%>
                <input type="submit" value="View Cart" name="btnAction" />
                <input type="submit" value="Change Password" name="btnAction" />
                <%} %>




                </tbody>
            </table>
        </form>
        <%
            String msg = (String) request.getAttribute("MSG");
            if (msg == null) {
                msg = "";
            }
        %>
        <h1><%= msg%></h1>
    </body>
</html>
