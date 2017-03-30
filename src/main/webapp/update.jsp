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
<div>
    <h3>Редактировать/Добавить блюдо</h3>
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
</div>

<style>
    input, button {
        display: block;
    }
    input {
        width: 300px;
        padding: 12px 20px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    button {
        width: 300px;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 20px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        float:left;
        width:auto;
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 50px;
    }
</style>
</body>
</html>
