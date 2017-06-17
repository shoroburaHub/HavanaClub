<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/15/2017
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>drink name</th>
                <th>recipe</th>
                <th>image</th>
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
                    <img src="${drink.pathImage}" alt="${drink.drinkName}" height="192px" width="150px">
                </td>
                <td>
                    <c:forEach items="${drink.ingredients}" var="country">
                        ${country.ingredientName} <br>
                    </c:forEach>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>