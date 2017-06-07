<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/5/2017
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

${user.name}
<br>
<br>
<br>
<%--<c:forEach var="drink" items="${userBasket.drinks}">--%>
    <%--${drink.drinkName}--%>
    <%--<a href="/deleteFromBasket/${userBasket.id}/${userBasket.id}">delete</a>--%>
    <%--<br>--%>
<%--</c:forEach>--%>

<%--<form:form action="/buy/${user.id}" method="post">--%>
    <%--<button class="btn btn-default">buy</button>--%>
<%--</form:form>--%>






<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>drink name</th>
            <th>ingredients</th>
            <th>drink recipe</th>
            <th>delete from basket</th>
            <th>
                <form:form action="/buy/${user.id}" method="post">
                    <button class="btn btn-default">buy</button>
                </form:form>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="drink" items="${userBasket.drinks}">
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
                        ${drink.recipe}
                </td>
                <td>
                    <a href="/deleteFromBasket/${userBasket.id}/${userBasket.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>