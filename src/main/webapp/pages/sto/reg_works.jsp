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
        <h2 style="text-align: center;" class="form-signin-heading">Форма регистрации работ</h2>

        <form:form method="post"  modelAttribute="STOWork">

            <div class="form-group" style=" text-align: -webkit-center;">
                <label>Сотрудник</label>
                <form:select cssStyle="width: 150px" class="form-control"  path="worker">
                    <form:options items="${worker}" />
                </form:select>
            </div>
            <div class="form-group" style=" text-align: -webkit-center;">
                <label >Автомобиль</label>
                <form:select cssStyle="width: 150px" class="form-control"  path="car_number">
                    <form:options items="${carNumber}" />
                </form:select>
            </div>
            <div class="form-group" style=" text-align: -webkit-center;">
                <label>Пробег</label>
                <form:input cssStyle="width: 150px; text-align: center" class="form-control" path="probeg" />
            </div>
            <div class="form-group" style=" text-align: -webkit-center;">
                <label>Проводимые работы</label>
                <form:textarea class="form-control" path="works" rows="3" cols="20"/>
                    <%--                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>--%>
            </div>

            <p style="text-align: -webkit-center">
                <button style="width: 200px"  class="btn btn-lg btn-primary btn-block"  type="submit">Зарегистрировать</button>
            </p>
            <p style="text-align: -webkit-center">
                <a style="width: 200px;" class="btn btn-lg btn-success btn-block"  href="<c:url value="/" />" role="button">Выйти</a> </p>
        </form:form>
    </sec:authorize>
</div>

</body>
</html>
