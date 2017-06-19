<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/19/2017
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="panel">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">

                    <input type="text" class="form-control" id="cityName"
                                placeholder="city name"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-default" id="saveCity">save city</button>
                </div>
            </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody id="result">
            </tbody>
        </table>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="/js/city.js"></script>


