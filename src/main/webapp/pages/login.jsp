<%@ page import="javax.xml.ws.Response" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Center City</title>

    <style>
        <%@include file='/pages/css/bootstrap.css' %>
        <%@include file='/pages/css/signin.css' %>
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<sec:authorize access="isAuthenticated()">

</sec:authorize>


<div class="container" style="width: 300px;">
    <form method="POST" action="/login">
        <h2 style="text-align: center;" class="form-signin-heading">Please sign in</h2>
        <input type="email" class="form-control" name="username" placeholder="Email address" autofocus="true"/>
        <input type="password" class="form-control" name="password" placeholder="Password" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
</body>
</html>
