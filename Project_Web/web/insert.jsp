<%-- 
    Document   : insert
    Created on : Jul 15, 2020, 2:16:36 PM
    Author     : ADMIN
--%>

<%@page import="huynm.books.ErrorBookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert A new Book</title>
    </head>
    <body>
        <h1>Insert A New Book</h1>
        <%
            ErrorBookDTO errorDTO = (ErrorBookDTO) request.getAttribute("ERROR_BOOK");
            if (errorDTO == null) {
                errorDTO = new ErrorBookDTO("", "", "", "", "", "", "", "");
            }
        %>
        <form action="MainController">
            Book ID <input type="text" name="txtBookID" value=""/><br/>
            <%= errorDTO.getErrorBookID()%><br/>
            Book Name <input type="text" name="txtBookName" value="" /><br/>
            <%= errorDTO.getErrorbookName()%><br/>
            Book Quantity <input type="text" name="txtBookQuantity" value="" /><br/>
            <%= errorDTO.getErrorBookQuantity()%><br/>
            Publisher <input type="text" name="txtPublisher" value="" /><br/>
            <%= errorDTO.getErrorPublisher()%><br/>
            Author <input type="text" name="txtAuthor" value="" /><br/>
            <%= errorDTO.getErrorAuthor()%><br/>
            Book Description <input type="text" name="txtBookDes" value="" /><br/>
            <%= errorDTO.getErrorDescrips()%><br/>
            Category <input type="text" name="txtCate" value="" /><br/>
            <%= errorDTO.getErrorCate()%><br/>
            Prices <input type="text" name="txtPrices" value="" /><br/>
            <%= errorDTO.getErrorPrice()%><br/>
            <input type="submit" value="Insert" name="btnAction" />
        </form>
    </body>
</html>
