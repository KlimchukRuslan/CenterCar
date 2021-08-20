<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AdminPanel</title>
    <style>
        <%@include file='/pages/css/bootstrap.css' %>
        <%@include file='/pages/css/signin.css' %>
    </style>
</head>

<body>
<div class="container"  >

    <p style="margin-left: 10px;"><a class="btn btn-lg btn-success" href="<c:url value="/" />" role="button">Главная</a></p>

    <div style="width: 45%; float: left; margin: 0 10px;">

        <p>
            <a style="margin-bottom: 10px;" class="btn btn-lg btn-danger" href="<c:url value="/update_user" />" role="button">Редактор Driver</a>
            <a style="margin-bottom: 10px;" class="btn btn-lg btn-success" href="<c:url value="/registration" />" role="button">Add Driver</a>
        </p>

        <table class="table table-striped">
            <thead>
            <th>Driver code</th>
            <th>DriverName</th>
            <th>PoneNumber</th>
            <th>Kurator</th>
            </thead>
            <c:forEach items="${allUsers}" var="user">
                <tr>
                    <td>${user.driver_code}</td>
                    <td>${user.username}</td>
                    <td>${user.pone_number}</td>
                    <td>${user.kurator}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

    <div style="width: 45%; float: left; margin: 0 10px;">

        <p>
            <a style="margin-bottom: 10px;" class="btn btn-lg btn-danger" href="<c:url value="/update_car" />" role="button">Редактор Car</a>
            <a style="margin-bottom: 10px;" class="btn btn-lg btn-success" href="<c:url value="/add_car" />" role="button">Add Car</a>
        </p>

        <table class="table table-striped">
            <thead>
            <%--              <th>ID</th>--%>
            <th>CarNumber</th>
            <th>Status</th>
            <th>Driver</th>
            <th>CarKurator</th>
            </thead>
            <c:forEach items="${getAll}" var="car">
                <tr>
                        <%--                  <td>${car.id}</td>--%>
                    <td>${car.car_number}</td>
                    <td>${car.car_status}</td>
                    <td>${car.car_driver}</td>
                    <td>${car.car_kurator}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>