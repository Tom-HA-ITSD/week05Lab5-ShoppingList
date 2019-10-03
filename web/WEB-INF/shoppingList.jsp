<%-- 
    Document   : shoppingList
    Created on : Oct 3, 2019, 4:10:31 PM
    Author     : 768661
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello ${username}<br>
        <a href="ShoppingList?action=logout">logout</a><br>
        <h2>List</h2>
        <form method="post" action="ShoppingList">
            Add item: <input type="text" name="newItem"> <input type="submit" value="add">
            <input type="hidden" name="action" value="add">
        </form>
        <form>
            <ul>
                <c:forEach items="${listItems}" var="item">
                    <li><input type="radio" name="selectItem" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
