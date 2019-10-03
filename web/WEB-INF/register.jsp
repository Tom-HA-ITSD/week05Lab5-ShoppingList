<%-- 
    Document   : register
    Created on : Oct 3, 2019, 4:10:20 PM
    Author     : 768661
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Username: <input type="text" name="username"> <input type="submit" value="register">
            <input type="hidden" name="action" value="register">
        </form>
    </body>
</html>
