<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <div class="panel">
        <sf:form modelAttribute="drink" action="/drink?${_csrf.parameterName}=${_csrf.token}"
                 method="post" enctype="multipart/form-data">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <sf:input path="drinkName" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="drink name"/>
                    <input type="file" name="image" class="form-control">
                </div>
                <div class="form-group">
                    <sf:textarea path="recipe" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="recipe"/>
                </div>
                <div class="form-group">
                    <select multiple name="ingredientsIds" type="text" class="form-control" id="exampleInputEmail3">
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
                <th>image</th>
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
                        <img src="${drink.pathImage}" alt="${drink.drinkName}" height="192px" width="150px">
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
                    <td>
                        <a href="updateDrink/${drink.id}">update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
