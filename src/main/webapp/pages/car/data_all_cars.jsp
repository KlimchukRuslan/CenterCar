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

    <title>Data Car</title>
    <style>
        <%@include file='/pages/css/bootstrap.css' %>
        <%@include file='/pages/css/signin.css' %>
    </style>
</head>

<body>
<div class="container" style="position: center">
    <p><a class="btn btn-lg btn-success" href="<c:url value="/admin" />" role="button">Панель</a>
        <a class="btn btn-lg btn-danger" href="<c:url value="/" />" role="button">Главная</a></p>

    <form action="${pageContext.request.contextPath}/data_car" method="post">
        <input type="hidden" name="all" value="All"/>
        С <input type="datetime-local" name="date_first" />
        По <input type="datetime-local" name="date_second" />

    <button style="margin-top: 10px" class="btn btn-lg btn-primary btn-block" type="submit">По всем</button>
    </form>
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Номер</th>
            <th>Трекер</th>
            <th>Дата</th>
            </thead>
            <c:forEach items="${allCar}" var="car">
            <tr>
                <form action="${pageContext.request.contextPath}/data_car" method="post">
                <td>${car.id}</td>
                <td>${car.car_number}</td>
                <td>${car.tracker}</td>
                <td style="width: 216px;">
                        <input type="datetime-local" name="date_first" /><br>
                        <input type="datetime-local" name="date_second" />
                </td>
                <td>
                    <input type="hidden" name="carId" value="${car.id}"/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Данные</button>
                </td>
                    </form>
            </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>

