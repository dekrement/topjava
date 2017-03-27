<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://example.com/functions" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<table class="meals">
    <thead>
    <tr>
        <th>Время</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="meal" items="${requestScope.meals}">
            <tr ${meal.exceed ? " class=\"exceed\"" : ""}>
                <td>
                    ${f:matches(meal.dateTime, "yyyy.MM.dd HH:mm")}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td>
                    <a href="?action=update&id=${meal.id}">Редактировать</a> |
                    <a href="?action=delete&id=${meal.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<p><a href="?action=add">Добавить</a></p>
<style>
    .meals td {
        color: green;
    }
    .meals .exceed td {
        color:red;
    }
</style>
</body>
</html>
