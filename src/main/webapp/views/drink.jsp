<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sf:form modelAttribute="drink" method="post">

		<sf:input path="name"/>

		<sf:select path="country" items="${countries}" itemLabel="name" itemValue="id"/>

		<sf:checkboxes element="div" path="ingredients" items="${ingredients}" itemLabel="name" itemValue="id"/>

		<button>save drink</button>

	</sf:form>



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