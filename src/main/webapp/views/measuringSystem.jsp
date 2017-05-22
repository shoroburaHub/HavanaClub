<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/measuringSystem" method="post">
		<input name="name">
		<button>save measuring system</button>
	</form>

	<ol>
		<c:forEach var="ms" items="${measuringSystems}">
			<li>${ms.name} <a href="/deleteMeasuringSystem/${ms.id}"> delete</a> <a href="/updateMeasuringSystem/${ms.id}"> update</a></li>
		</c:forEach>
	</ol>

</body>
</html>