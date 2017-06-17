<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/8/2017
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>drink name</th>
            <th>ingredients</th>
            <th>recipe</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                ${drink.drinkName}
            </td>
            <td>
                <c:forEach items="${drink.ingredients}" var="country">
                    ${country.ingredientName} <br>
                </c:forEach>
            </td>
            <td>
                ${drink.recipe}
            </td>
        </tr>
        </tbody>
    </table>
</div>
