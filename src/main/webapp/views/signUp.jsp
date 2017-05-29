<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/css/signUp.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/signUp.js"></script>
</head>
<body>


<div class="form-wrap">
    <div class="tabs">
        <h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
        <h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
        <div id="signup-tab-content" class="active">
            <form:form modelAttribute="user" class="signup-form" method="post">
                <span style="color: red">${usernameException}</span>
                <form:input path="name" type="text" class="input" id="user_name" autocomplete="off" placeholder="${usernameException}Username"/>
                <form:input path="email" type="email" class="input" id="user_email" autocomplete="off" placeholder="Email"/>
                <form:input path="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password"/>
                <input type="submit" class="button" value="Sign Up">
            </form:form><!--.login-form-->
            <div class="help-text">
                <p>By signing up, you agree to our</p>
                <p><a href="#">Terms of service</a></p>
            </div><!--.help-text-->
        </div><!--.signup-tab-content-->

        <div id="login-tab-content">
            <form class="login-form" action="" method="post">
                <input type="text" class="input" id="user_login" autocomplete="off" placeholder="Email or Username">
                <input type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
                <input type="checkbox" class="checkbox" id="remember_me">
                <label for="remember_me">Remember me</label>

                <input type="submit" class="button" value="Login">
            </form><!--.login-form-->
            <div class="help-text">
                <p><a href="#">Forget your password?</a></p>
            </div><!--.help-text-->
        </div><!--.login-tab-content-->
    </div><!--.tabs-content-->
</div><!--.form-wrap-->
</body>
</html>