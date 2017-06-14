<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">


    <div class="panel">
        <form:form modelAttribute="country"
                   action="/country?${_csrf.parameterName}=${_csrf.token}"
                   method="post" enctype="multipart/form-data">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    ${nameException}
                    <form:input path="name" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="country name"/>
                </div>
                <div class="form-group">
                    <input name="image" type="file" class="form-control"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-default">save country</button>
                </div>
            </div>
        </form:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>image</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="country" items="${countries}">
                <tr>
                    <td>
                            ${country.name}
                    </td>
                    <td>
                        <img src="${country.pathImage}" alt="" width="20%" height="20%">
                    </td>
                    <td>
                        <a href="/updateCountry/${country.id}">update</a>
                    </td>
                    <td>
                        <a href="deleteCountry/${country.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
