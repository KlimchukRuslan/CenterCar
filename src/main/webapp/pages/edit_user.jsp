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

  <title>EditUser</title>
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
        <input type="hidden" name="action" value=${user.id}/>
        <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px" type="submit">Сохранить</button>
    </form:form>

    <p> <a class="btn btn-lg btn-success btn-block" style="margin-top: 10px" href="<c:url value="/update_user" />" role="button">Отменить</a> </p>
    <p> <a class="btn btn-lg btn-success btn-block" href="<c:url value="/admin" />" role="button">Панель</a></p>
</div>
</body>
</html>