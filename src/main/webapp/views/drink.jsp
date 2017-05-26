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

	<sf:form modelAttribute="drinkDtoCreate" method="post">

		<sf:input path="name"/>

		<sf:select path="countryDto" items="${countriesDtos}" itemLabel="name" itemValue="id"/>

		<sf:checkboxes element="div" path="ingredientDtos" items="${ingredientsDtos}" itemLabel="name" itemValue="id"/>

		<button>save drink</button>

		<sf:errors path="*"/>

	</sf:form>


	<ol>
		<c:forEach var="drinkDto" items="${drinksDtos}">
			<li>${drinkDto.name}
				<a href="/deleteDrink/${drinkDto.id}">delete</a> <a
				href="/updateDrink/${drinkDto.id}">update</a>
			</li>
		</c:forEach>
	</ol>

</body>
</html>