<%-- 
    Document   : createaccount
    Created on : Jul 13, 2020, 8:01:40 AM
    Author     : ADMIN
--%>

<%@page import="huynm.error.ErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign-in</title>
    </head>
    <body>
        <%
            ErrorDTO errorDTO = (ErrorDTO) request.getAttribute("ERROR_USER");
            if (errorDTO == null) {
                errorDTO = new ErrorDTO("", "", "", "");
            }
        %>
        <form action="MainController">
        <h1>Create A New User</h1>
        User Name <input type="text" name="txtUserName" value="" /><br/>
        <%= errorDTO.getErrorUserID() %><br/>
        Full Name <input type="text" name="txtFullName" value="" /><br/>
        <%= errorDTO.getErrorFullName()%><br/>
        Enter Password : <input type="password" name="txtPassword" value="" /><br/>
        <%= errorDTO.getErrorPassword()%><br/>
        Re-Password : <input type="password" name="txtRePassword" value="" /><br/>
        <%= errorDTO.getErrorRePassword() %><br/>
        <input type="submit" value="Create" name="btnAction" />
        </form>
    </body>
</html>
