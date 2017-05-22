<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- ${flag}

	<c:if test="${flag!=1}">
			some
	</c:if> --%>



	<form action="/drink" method="post">

		<input name="name" type="text"> <select name="countryId">
			<option value="${country.id}">${country.name}</option>
			<c:forEach var="country" items="${countries}">
				<option value="${country.id}">${country.name }</option>
			</c:forEach>
		</select> 





		<%-- <select multiple="multiple" name="ingredientIds">
			<c:forEach var="ingredient" items="${ingredients}">
				<option value="${ingredient.id}">${ingredient.name}</option>
			</c:forEach>
		</select> --%>


		<c:forEach var="ingredient" items="${ingredients}">
			<input type="checkbox" name="ingredientIds" value="${ingredient.id}" />${ingredient.name}
		</c:forEach>

		<button>save drink</button>

	</form>
	<ol>
		<c:forEach var="drink" items="${drinks}">
			<li>${drink.name}${drink.country.name} <c:forEach
					var="ingredient" items="${drink.ingredients}">
				${ingredient.name}
			</c:forEach> <a href="/deleteDrink/${drink.id}">delete</a> <a
				href="/updateDrink/${drink.id}">update</a>
			</li>
		</c:forEach>
	</ol>

</body>
</html>