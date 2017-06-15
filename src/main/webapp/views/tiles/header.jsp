<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/31/2017
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/css/header.css">

<header class="header" role="banner">
    <nav>
        <ul>
            <li class="active">
                <a href="/">Home</a>
            </li>
            <li>
                <a href="/random">random</a>
            </li>
            <sec:authorize access="hasAnyRole('ROLE_USER')">
                <li class="active">
                    <a href="/profile">profile</a>
                </li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li>
                    <a href="/signUp">sign up</a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li>
                    <a href="/drink">drinks</a>
                </li>
                <li>
                    <a href="/ingredient">ingredients</a>
                </li>
                <li>
                    <a href="/country">countries</a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <li>
                    <a href="/history">history</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li>
                    <form:form action="/logout" method="post" cssStyle="float: right">
                        <button class="btn btn-default">logout</button>
                    </form:form>
                </li>
            </sec:authorize>
        </ul>
    </nav>
</header>
<br>
<br>
<br>
<br>
<br>