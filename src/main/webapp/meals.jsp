<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <tr<c:if test="${meal.isExceed()}"> class="exceed"</c:if>>
                <td>
                    <c:set var="dateTime" value="${meal.getDateTime()}"/>
                    <c:set var="cleanedDateTime" value="${fn:replace(dateTime, 'T', ' ')}"/>
                    <fmt:parseDate value="${cleanedDateTime}" pattern="yyyy-MM-dd HH:mm"
                                   var="parsedDate" type="both"/>
                    <fmt:formatDate
                        value="${parsedDate}"
                        pattern="yyyy.MM.dd HH:mm"/></td>
                <td>${meal.getDescription()}</td>
                <td>${meal.getCalories()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
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
