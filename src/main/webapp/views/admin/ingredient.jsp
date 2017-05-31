<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">

	<div class="panel">
		<sf:form modelAttribute="ingredient" method="post">
			<div style="display: flex; justify-content: space-around ">

				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail3">Email address</label>
					<sf:input path="ingredientName" type="text" class="form-control" id="exampleInputEmail3"
							  placeholder="ingredient name"/>
				</div>

				<div class="form-group">
					<button class="btn btn-default">save ingredient</button>
				</div>
			</div>
		</sf:form>
		<table class="table table-hover">
			<thead>
			<tr>
				<th>ingredient name</th>
				<th>delete</th>
			</tr>
			</thead>
			<tbody>

			<c:forEach var="ingredient" items="${ingredients}">
				<tr>
					<td>
                            ${ingredient.ingredientName}
					</td>
					<td>
						<a href="deleteIngredient/${ingredient.id}">delete</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>

