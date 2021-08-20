<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Ruslan Klimchuk">

    <title>Center City</title>
    <style>
        <%@include file='/pages/css/bootstrap.css' %>
        <%@include file='/pages/css/signin.css' %>
        /*mobile*/
        @media screen and (max-width: 768px) {
            .container{
                width: 100%;
            }
            form{
                width: 100%;
            }
        }
        /* pc */
        @media screen and (min-width: 1240px)  {
            .container{
                width: 450px;
            }
            form{
                width: 400px;
            }
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body style="padding-top: 10px;">

<div class="container" >

    <sec:authorize access="!isAuthenticated()">
        <p class="lead">Для доступа к этой стрице нужно авторизоватся</p>
        <p><a class="btn btn-lg btn-success" href="<c:url value="/login"/>" role="button">Войти</a></p>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <form:form  method="POST" modelAttribute="carForm" >
            <h2 style="text-align: center;" class="form-signin-heading">Пересменка</h2>

            <label>Автомобиль:</label>
            <div>
                <form:select class="form-control"  path="car_number">
                    <form:options items="${carNumber}" />
                </form:select>
            </div>

            <label>Пробег при передачи:</label>
            <form:input class="form-control"  type="text" path="probeg" placeholder="111111" autofocus="true"></form:input>
            <form:errors path="probeg"></form:errors>
            ${probegError}
            <label>Текущий водитель:</label>
            <div>
                <form:select class="form-control"  path="old_driver">
                    <form:options items="${userName}" />
                </form:select>
                    ${driverError}
            </div>

            <label>Новый водитель::</label>
            <div>
                <form:select class="form-control"  path="new_driver">
                    <form:options items="${userName}" />
                </form:select>

            </div>

            <label>Дата пересменки:</label>
            <div>
                <form:input class="form-control"  type="datetime-local" path="time"  autofocus="true"></form:input>
            </div>

            <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px" type="submit">Добавить</button>
        </form:form>
    </sec:authorize>
</div>

</body>
</html>
