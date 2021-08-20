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

        <p class="lead">Welcome to Center City</p>

        <sec:authorize access="!isAuthenticated()">
            <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/login"/>" role="button">Войти</a></p>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <p>Пользователь: <sec:authentication property="principal.username" /></p>

            <sec:authorize access="hasRole('ROLE_USER')">
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/employee" />" role="button">GET CAR</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/get_user_fin" />" role="button">Выплаты</a></p>
                <%--            <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/get_user_fin" />" role="button">Выплаты</a></p>--%>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_FIN')">
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/fin_edit" />" role="button">Редактор вы-т</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/get_user_fin" />" role="button">Выплаты</a></p>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_KURATOR')">
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/probeg_car" />" role="button">Пробеги</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/employee" />" role="button">GET CAR</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/admin" />" role="button">Панель</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/data_user" />" role="button">Водители</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/fin_edit" />" role="button">Редактор вы-т</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/get_user_fin" />" role="button">Выплаты</a></p>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_MEHANIK')">
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/reg_works" />" role="button">Работа</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/employee" />" role="button">GET CAR</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/get_user_fin" />" role="button">Выплаты</a></p>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/registration" />" role="button">Регистрация</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/employee" />" role="button">GET CAR</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/admin" />" role="button">Панель</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/probeg_car" />" role="button">Пробеги</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/data_user" />" role="button">Водители</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/add_transfer" />" role="button">Пересменка</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/fin_edit" />" role="button">Редактор вы-т</a></p>
                <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/get_user_fin" />" role="button">Выплаты</a></p>
            </sec:authorize>
            <p><a style="width: 200px;" class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
        </sec:authorize>
    </div>

    <div class="footer">
        <p>&copy; Center City</p>
    </div>

</div>
</body>
</html>
