<%@ page import="ru.javawebinar.topjava.AuthorizedUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("id", AuthorizedUser.id());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Java Enterprise (Topjava)</title>
</head>
<body>
<h3>Проект <a href="https://github.com/JavaWebinar/topjava10" target="_blank">Java11 Enterprise (Topjava)</a></h3>
<hr>
<h2>Choose user:</h2>
<form action="users" method="post">
    <select name="currentUser" id="">
        <option value="1" <c:if test="${id == '1'}"> selected</c:if>>User 1</option>
        <option value="2" <c:if test="${id == '2'}"> selected</c:if>>User 2</option>
    </select>
    <button type="submit">Change user</button>
</form>
<ul>
    <li><a href="users">User List</a></li>
    <li><a href="meals">Meal List</a></li>
</ul>
</body>
</html>
