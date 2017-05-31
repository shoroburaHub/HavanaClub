<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/24/2017
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update drinks</title>
</head>
<body>

    <form:form modelAttribute="updateDrink" method="post">

        <form:input path="drinkName" value="${updateDrink.name}"/>

        <br>

        <c:forEach items="${updateDrink.ingredients}" var="ingredient">
            ${ingredient.name} <a href="/updateDrink/${updateDrink.id}/${ingredient.id}">delete ingredient</a><br>
        </c:forEach>

        <button>update drink</button>
    </form:form>

</body>
</html>
