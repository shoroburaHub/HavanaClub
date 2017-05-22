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

	<form action="/ingredient" method="post">


		<input name="name" type="text">
		 <input name="quantity">
		 
		  <select name="ms">
		  <option>choose measuring system</option>
			<c:forEach var="ms" items="${measuringSystems}">
				<option value="${ms.id}">${ms.name}</option>
			</c:forEach>
		</select>

		<button>save ingredient</button>

	</form>

	<ol>
		<c:forEach var="ingredient" items="${ingredients}">
			
		<li>${ingredient.name} ${ingredient.quantity} 
			<c:forEach var="ms" items="${ingredient.measuringSystems}">
				${ms.name}
			</c:forEach>
			<a href="/deleteIngredient/${ingredient.id}">delete</a>	
			<a href="/updateIngredient/${ingredient.id}">update</a>	
		</li>
		</c:forEach>
	</ol>
</body>
</html>