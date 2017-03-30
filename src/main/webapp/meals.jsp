<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://example.com/functions" %>
<jsp:useBean id="meals" type="java.util.List<ru.javawebinar.topjava.model.MealWithExceed>" scope="request"/>
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
        <th>Действия</th>
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
    .meals {
        border: 1px solid #000000;
    }
    .meals td, .meals th {
        padding: 5px 10px;
        border: 1px solid #000000;
    }
    .meals td {
        color: green;
    }
    .meals .exceed td {
        color:red;
    }
</style>
</body>
</html>
