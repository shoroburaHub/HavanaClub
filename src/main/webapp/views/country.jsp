<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
        <sf:form modelAttribute="country" method="post">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    ${nameException}
                    <sf:input path="name" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="country name"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-default">save country</button>
                </div>
            </div>
        </sf:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ingredient" items="${countries}">
                <tr>
                    <td>
                            ${ingredient.name}
                    </td>
                    <td>
                        <a href="deleteCountry/${ingredient.id}">del</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>