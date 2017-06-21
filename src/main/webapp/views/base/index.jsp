<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>

    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>drink name</th>
                <th></th>
                <th>ingredients</th>
                <th>
                    <div class="form-group; col-lg-10">
                        <input type="text" class="form-control" id="searchIn"
                               placeholder="search" oninput="search()"/>
                    </div>
                </th>
            </tr>
            </thead>
            <tbody id="indexResult">
            <c:forEach var="drink" items="${drinks.content}">
                <tr>
                    <td>
                            ${drink.drinkName}
                    </td>
                    <td>
                        <img src="${drink.pathImage}" alt="${drink.drinkName}" height="192px" width="150px">
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
        <div style="display: flex; justify-content: center; margin-left: 10%">
            <div class="col-md-12 col-xs-12">
                <div class="row">
                    <div class="col-md-2 col-xs-6">
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort
                                <span
                                        class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <custom:sort innerHtml="Name asc" paramValue="drinkName"/>
                                <custom:sort innerHtml="Name desc" paramValue="drinkName,desc"/>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-12 text-center">
                        <custom:pageable page="${drinks}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
                    </div>
                    <div class="col-md-2 col-xs-6">
                        <custom:size posibleSizes="1,2,5,10" size="${drinks.size}"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="/js/speedSearch.js"></script>