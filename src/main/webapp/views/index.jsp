<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

    <div class="container">

        <div id="products" class="row list-group">

            <c:forEach var="drink" items="${drinks}">


                <div class="item  col-xs-5 col-lg-4">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">
                                    ${drink.drinkName}</h4>
                            <p class="group inner list-group-item-text"></p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>