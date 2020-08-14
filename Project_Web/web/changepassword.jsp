<%-- 
    Document   : changepassword
    Created on : Jul 11, 2020, 9:17:42 PM
    Author     : ADMIN
--%>

<%@page import="huynm.error.ErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password Page</title>
    </head>
    <body>
        <h1>Change Password Page</h1>
        <%
            ErrorDTO errorDTO = (ErrorDTO) request.getAttribute("ERROR_USER");
            if (errorDTO == null) {
                errorDTO = new ErrorDTO("", "", "");
            }
        %>
        <form action="MainController" method = "POST">
            Enter Your Password : <input type="password" name="txtOldPassword" value="" /><br/>
            <%= errorDTO.getErrorPassword()%><br/>
            Enter Your New Password : <input type="password" name="txtNewPassword" value="" /><br/>
            <%= errorDTO.getErrorNewPassword()%><br/>
            Enter Your New Password again : <input type="password" name="txtRePassword" value="" /><br/>
            <%= errorDTO.getErrorRePassword()%><br/>
            <input type="submit" value="Change" name="btnAction" />
        </form>
    </body>
</html>
