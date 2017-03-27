<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meваыаываываal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Добавление</h2>
<form action="update" method="post">
    <p>
        <label for="dateTime">Время</label>
        <input type="datetime" name="dateTime">
    </p>
    <p>
        <label for="description">Описание</label>
        <input type="text" name="description">
    </p>
    <p>
        <label for="calories">Калории</label>
        <input type="number" name="calories">
    </p>

</form>
</body>
</html>
