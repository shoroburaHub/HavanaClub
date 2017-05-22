<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/22/2017
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
    <link rel="stylesheet" href="/css/signUp.css" type="text/css">
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
            <form class="signup-form" action="/signUp" method="post">
                <input name="name" type="text" class="input" id="user_name" autocomplete="off" placeholder="Username">
                <input name="email" type="email" class="input" id="user_email" autocomplete="off" placeholder="Email">
                <input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
                <input type="submit" class="button" value="Sign Up">
            </form><!--.login-form-->
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
