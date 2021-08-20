<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%--
  Created by IntelliJ IDEA.
  User: VideoUser
  Date: 30.03.2020
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Change Pass</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <style>
        <%@include file='/pages/css/bootstrap.css' %>
        <%@include file='/pages/css/signin.css' %>
    </style>
</head>

<body>
<div class="container" style="width: 300px;">

    <form:form  method="POST" modelAttribute="editForm" >
        <h2 style="text-align: center;">Редактирование пользователя:</h2>
        <h2 style="text-align: center;" class="form-signin-heading">${polzovatel} </h2>

                <form:label  path="username">Пароль:</form:label>
                <div>
                    <form:input class="form-control" type="password" path="password" placeholder="Password"></form:input>
                </div>

                <form:label  path="username">Проверка пароля:</form:label>
                <div>
                    <form:input class="form-control" type="password" path="passwordConfirm"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="password"></form:errors>
                        ${passwordError}
                </div>
        <input type="hidden" name="action" value=${user.id}/>
        <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px" type="submit">Сохранить</button>
    </form:form>

    <p> <a class="btn btn-lg btn-success btn-block" style="margin-top: 10px" href="<c:url value="/update_user" />" role="button">Отменить</a> </p>
    <p> <a class="btn btn-lg btn-success btn-block" href="<c:url value="/admin" />" role="button">Панель</a></p>
    <%--  <a href="/">Главная</a>--%>
</div>
</body>
</html>
