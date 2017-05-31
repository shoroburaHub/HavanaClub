<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/31/2017
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="/css/header.css">
    <script src="/js/header.js"></script>
</head>
<body>
    <div><tiles:insertAttribute name="header"/></div>
    <div><tiles:insertAttribute name="body"/></div>
    <div><tiles:insertAttribute name="footer"/></div>
</body>
</html>
