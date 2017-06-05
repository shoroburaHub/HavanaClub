<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>


</head>
<body>
<div>




    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>drink name</th>
                <th>ingredients</th>
                <th>
                    <li>
                        <div class="form-group; col-lg-10">
                            <label class="sr-only" for="search">Email address</label>
                            <input type="text" class="form-control" id="search"
                                   placeholder="search"/>
                        </div>
                    </li>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="drink" items="${drinks}">
                <tr>
                    <td>
                            ${drink.drinkName}
                    </td>
                    <td>
                        <c:forEach items="${drink.ingredients}" var="ingredient">
                            ${ingredient.ingredientName} <br>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="recipe/${drink.id}">recipe</a>
                    </td>
                    <td>
                        <a href="like/${drink.id}">like</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>