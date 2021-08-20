<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Регистрация</title>
  <style>
    <%@include file='/pages/css/bootstrap.css' %>
    <%@include file='/pages/css/signin.css' %>
  </style>
</head>

<body>
<div class="container" style="width: 300px;">

  <form:form  method="POST" modelAttribute="userForm" >
    <h2 style="text-align: center;" class="form-signin-heading">Регистрация</h2>

    <form:label  path="username">Имя Фамилия:</form:label>
    <div>
      <form:input class="form-control"  type="text" path="username" placeholder="Username" autofocus="true"></form:input>
    </div>

    <form:label  path="username">Email:</form:label>
    <div>
      <form:input class="form-control" type="email" path="email" placeholder="Email" autofocus="true"></form:input>
      <form:errors path="email"></form:errors>
        ${emailError}
    </div>

    <form:label  path="username">Номер телефона:</form:label>
    <div>
      <form:input class="form-control"  type="text" path="pone_number" placeholder="Phone number" autofocus="true"></form:input>
    </div>

    <form:label  path="username">Код пользователя:</form:label>
    <div>
      <form:input class="form-control"  type="text" path="driver_code" placeholder="DV-000000" ></form:input>
      <form:errors path="driver_code"></form:errors>
        ${driver_codeError}
    </div>

    <form:label  path="username">Куратор:</form:label>
    <div>
      <form:input class="form-control"  type="text" path="kurator" placeholder="Kurator" ></form:input>
      <form:errors path="kurator"></form:errors>
        ${curatorError}
    </div>

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

    <%--    <button type="submit" class="btn btn-primary btn-lg">Зарегистрировать</button>--%>
    <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px" type="submit">Зарегистрировать</button>
    <%--    <button type="submit">Зарегистрировать</button>--%>

  </form:form>

  <p> <a class="btn btn-lg btn-success btn-block" style="margin-top: 10px" href="<c:url value="/admin" />" role="button">Панель</a> </p>
  <p> <a class="btn btn-lg btn-success btn-block" href="<c:url value="/" />" role="button">Главная</a></p>
  <%--  <a href="/">Главная</a>--%>
</div>
</body>
</html>