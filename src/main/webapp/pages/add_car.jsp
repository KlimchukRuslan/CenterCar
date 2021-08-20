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

  <form:form  method="POST" modelAttribute="carForm" >
    <h2 style="text-align: center;" class="form-signin-heading">Добавить ТС</h2>

    <div>
      <form:input class="form-control"  type="text" path="car_number" placeholder="AA 0000 BB" autofocus="true"></form:input>
      <form:errors path="car_number"></form:errors>
        ${car_numberError}
    </div>


    <div>
      <form:input class="form-control"  type="text" path="car_kurator" placeholder="Kurator" ></form:input>
    </div>

    <div>
      <form:input class="form-control" type="text" path="car_status" placeholder="Status" ></form:input>
    </div>

    <div>
      <form:input class="form-control"  type="text" path="car_driver" placeholder="Driverr" ></form:input>
    </div>

    <div>
      <form:input class="form-control"  type="text" path="tracker" placeholder="Tracker number" ></form:input>
    </div>

    <div>
      <form:input class="form-control"  type="text" path="probeg" placeholder="Mileage" ></form:input>
    </div>

    <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px" type="submit">Зарегистрировать</button>

  </form:form>

  <p> <a class="btn btn-lg btn-success btn-block" style="margin-top: 10px" href="<c:url value="/admin" />" role="button">Панель</a> </p>
  <p> <a class="btn btn-lg btn-success btn-block" href="<c:url value="/" />" role="button">Главная</a></p>

</div>
</body>
</html>