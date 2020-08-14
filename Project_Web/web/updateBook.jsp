<%-- 
    Document   : updateBook
    Created on : Jul 13, 2020, 5:02:35 PM
    Author     : ADMIN
--%>

<%@page import="huynm.books.ErrorBookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update Page</h1>
        <%
            String bookID = request.getParameter("txtBookID");
            if (bookID == null) {
                bookID = "";
            }
            String fullname = request.getParameter("txtBookName");
            if (fullname == null) {
                fullname = "";
            }
            String quantity = request.getParameter("txtBookQuantity");
            if (quantity == null) {
                quantity = "";
            }
            String bookDes = request.getParameter("txtBookDes");
            if (bookDes == null) {
                bookDes = "";
            }
            String prices = request.getParameter("txtPrices");
            if (prices == null) {
                prices = "";
            }
            String searchValues = request.getParameter("txtSearchValue");
            if (searchValues == null) {
                searchValues = "";
            }
        %>
        <%
            ErrorBookDTO errorDTO = (ErrorBookDTO) request.getAttribute("ERROR_BOOK");
            if (errorDTO == null) {
                errorDTO = new ErrorBookDTO("", "", "", "");
            }
        %>

        <form action="MainController">
            <input type="hidden" name="txtBookID" value="<%= bookID%>"/><br/>
            Book Name <input type="text" name="txtBookName" value="<%= fullname%>" /><br/>
            <%= errorDTO.getErrorbookName()%><br/>
            Book Quantity <input type="text" name="txtBookQuantity" value="<%= quantity %>" /><br/>
            <%= errorDTO.getErrorBookQuantity() %><br/>
            Book Description <input type="text" name="txtBookDes" value="<%= bookDes %>" /><br/>
            <%= errorDTO.getErrorDescrips() %><br/>
            Role ID <input type="text" name="txtPrices" value="<%= prices %>" /><br/>
            <%= errorDTO.getErrorPrice() %><br/>
            <input type="hidden" name="txtSearch" value="<%= searchValues%>" />
            <input type="submit" value="Update" name="btnAction" />
        </form>
    </body>
</html>
