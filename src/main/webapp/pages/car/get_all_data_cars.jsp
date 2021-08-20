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

    <title>MilageUser</title>
    <style>
        <%@include file='/pages/css/bootstrap.css' %>
        <%@include file='/pages/css/signin.css' %>
    </style>
</head>

<body>
<div class="container" style="position: center">
    <p><a class="btn btn-lg btn-success" href="<c:url value="/probeg_car" />" role="button">Назад</a>
        <a class="btn btn-lg btn-success" href="<c:url value="/" />" role="button">Главная</a></p>

    <table class="table table-striped">
        <thead>
        <th>Автомобиль</th>
        <th>Трекер</th>
        <th>Пробег</th>
        </thead>
        <c:forEach items="${allCar}" var="car">
            <tr>
                <td>${car.car_number}</td>
                <td>${car.tracker}</td>
                <td>${car.probeg}</td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>