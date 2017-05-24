<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="country" method="post">

		<form:input path="name"/>

		<button>save Country</button>

	</form:form>




	<%--<form action="/country" method="post">
		<input name="nameCountry">
		<button>save country</button>
	</form>--%>

	
	<ol>
		<c:forEach var="country" items="${countries}">
			<li>${country.name} <a href="/deleteCountry/${country.id}">delete</a></li>
		</c:forEach>
	</ol>
	
	
</body>
</html>