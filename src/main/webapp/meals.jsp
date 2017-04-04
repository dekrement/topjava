<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.jsp">Home</a></h2>
    <h2>Meal list</h2>
    <h3>Filter:</h3>
    <form action="meals" method="post" id="filter">
        <table>
            <thead>
            <th>From Date:</th>
            <th>To Date:</th>
            </thead>
            <tbody>
            <tr>
                <td><input type="date" name="startDate" value="${startDate}"></td>
                <td><input type="date" name="endDate" value="${endDAte}"></td>
            </tr>
            </tbody>
        </table>
        <table>
            <thead>
            <th>From Time:</th>
            <th>To Time:</th>
            </thead>
            <tbody>
            <td><input type="time" name="startTime" value="${startTime}"></td>
            <td><input type="time" name="endTime" value="${endTime}"></td>
            </tbody>
        </table>
        <button type="submit">Apply Filter</button>
        <button type="reset" form="filter">Reset</button>
    </form>

    <a href="meals?action=create">Add Meal</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
