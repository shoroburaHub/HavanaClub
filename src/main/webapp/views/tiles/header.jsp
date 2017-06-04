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

<header class="header" role="banner">
    <nav>
        <ul>
            <li class="active">
                <sec:authentication property="name"/>
            </li>
            <li class="active">
                <a href="/">Home</a>
            </li>
            <li>
                <a href="/signUp">sign up</a>
            </li>
            <li>
                <a href="/drink">drinks</a>
            </li>
            <li>
                <a href="/ingredient">ingredients</a>
            </li>
            <li>
                <a href="/country">countries</a>
            </li>
            <li>
                <form:form action="/logout" method="post">
                    <button class="btn btn-default">logout</button>
                </form:form>
            </li>
        </ul>
    </nav>
</header>
<br>
<br>
<br>
<br>
<br>