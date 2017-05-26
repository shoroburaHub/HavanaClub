<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h1 style="text-align: center;">index</h1>

<div>



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
    <ol>
        <c:forEach items="${userDtos}" var="userDto">
            <li>${userDto.name} ${userDto.email}</li>
        </c:forEach>
    </ol>
</div>
</body>
</html>