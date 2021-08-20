<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

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
        <%@include file='/pages/css/jumbotron-narrow.css' %>
        <%@include file='/pages/css/bootstrap.css' %>
    </style>

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <div class="jumbotron" style="margin-top: 20px;">


        <sec:authorize access="!isAuthenticated()">
            <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/login"/>" role="button">Войти</a></p>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <h1>Готово!</h1>
            <p class="lead">Операция проведена успешно.</p>
            <p style="text-align: -webkit-center"><a style="width: 200px;" class="btn btn-lg btn-danger" href="<c:url value="/fin_edit" />" role="button">Назад</a></p>
        </sec:authorize>
    </div>

    <div class="footer">
        <p>&copy; Center City</p>
    </div>

</div>
</body>
</html>
