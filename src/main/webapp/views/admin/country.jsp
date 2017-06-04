<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<div class="container">


    <div class="panel">
        <sf:form modelAttribute="country"  method="post">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    ${nameException}
                    <sf:input path="name" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="country name"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-default">save country</button>
                </div>
            </div>
        </sf:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ingredient" items="${countries}">
                <tr>
                    <td>
                            ${ingredient.name}
                    </td>
                    <td>
                        <a href="deleteCountry/${ingredient.id}">del</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
