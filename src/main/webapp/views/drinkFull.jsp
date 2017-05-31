<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/29/2017
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="/css/header.css">
    <script src="/js/header.js"></script>
</head>
<body>
<header class="header" role="banner">
    <nav>
        <ul>
            <li class="active"><a href="/">Home</a>
            </li>
            <li><a href="/signUp">sign up</a>
            </li>
            <li><a href="/drink">drinks</a>
            </li>
            <li><a href="/ingredient">ingredients</a>
            </li>
            <li><a href="/country">countries</a>
            </li>
        </ul>
    </nav>
</header>

<br>
<br>
<br>
<br>
<br>

<div class="container">

    <div class="panel">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>recipe</th>
                <th>ingredients</th>
            </tr>
            </thead>
            <tbody>

                <tr>
                    <td>
                            ${drink.drinkName}
                    </td>
                    <td>
                            ${drink.recipe}
                    </td>
                    <td>
                        <c:forEach items="${drink.ingredients}" var="ingredient">
                            ${ingredient.ingredientName} <br>
                        </c:forEach>
                    </td>

                </tr>

            </tbody>
        </table>
    </div>
</div>

</body>
</html>
