<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
                        <c:forEach items="${drink.ingredients}" var="country">
                            ${country.ingredientName} <br>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="recipe/${drink.id}">recipe</a>
                    </td>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <td>
                        <c:choose>
                            <c:when test="${user.drinks.contains(drink)}">
                                <td>drink already in basket</td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <a href="/addIntoBasket/${drink.id}">basket</a>
                                </td>
                            </c:otherwise>
                        </c:choose>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

${user.drinks}

