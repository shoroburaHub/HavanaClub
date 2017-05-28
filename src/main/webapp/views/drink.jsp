<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <sf:form modelAttribute="drink" method="post">
            <sf:errors path="*"/>
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    <sf:input path="drinkName" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="drink name"/>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    <sf:input path="recipe" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="recipe"/>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    <select multiple name="countryIds" type="text" class="form-control" id="exampleInputEmail3">
                        <option>choose ingredients</option>
                        <c:forEach var="ingredient" items="${ingredients}">
                            <option value="${ingredient.id}">${ingredient.ingredientName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <button class="btn btn-default">save ingredient</button>
                </div>
            </div>
        </sf:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>recipe</th>
                <th>ingredients</th>
                <th>delete</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="drink" items="${drinks}">
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

                    <td>
                        <a href="deleteDrink/${drink.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>