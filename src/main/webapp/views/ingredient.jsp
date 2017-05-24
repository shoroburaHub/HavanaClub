<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="ingredient" method="post">


		<form:input path="name"/>
		<form:input path="quantity"/>

		<button>save ingredient</button>

	</form:form>

	<ol>
		<c:forEach var="ingredient" items="${ingredients}">
			
		<li>${ingredient.name} ${ingredient.quantity}
			<a href="/deleteIngredient/${ingredient.id}">delete</a>	
			<a href="/updateIngredient/${ingredient.id}">update</a>	
		</li>
		</c:forEach>
	</ol>
</body>
</html>