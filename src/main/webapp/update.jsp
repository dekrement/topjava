<%--
  Created by IntelliJ IDEA.
  User: web
  Date: 27.03.2017
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать/Добавить блюдо</title>
</head>
<body>
<form action="?update" method="post">
    <input type="hidden" name="id" value="${meal.id}">
    <label for="dateTime">Дата и Время:</label>
    <input id="dateTime" name="dateTime" type="datetime-local" value="${meal.dateTime}"> <br>
    <label for="description">Описание:</label>
    <input type="text" name="description" id="description" value="${meal.description}"><br>
    <label for="calories">Калории:</label>
    <input type="number" name="calories" id="calories" value="${meal.calories}">
    <button type="submit">Сохранить</button>
</form>
</body>
</html>
