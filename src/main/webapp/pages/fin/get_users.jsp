<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    <title>FinPanel</title>
    <style>
        <%@include file='/pages/css/bootstrap.css' %>
        <%@include file='/pages/css/signin.css' %>
    </style>
</head>

<body>
<div class="container" style="position: center">
    <p><a class="btn btn-lg btn-success" href="<c:url value="/" />" role="button">Главная</a></p>


<div style="text-align: -webkit-center">
    <table>
        <sec:authorize access="hasRole('ROLE_FIN')">
        <form action="${pageContext.request.contextPath}/fin_edit_date" method="post">
            <tr>
                <td><label>ВЫПЛАТА от: </label>&nbsp;<input type="date" name="vyplata"></td>
                <td><label>Неделя: </label>&nbsp;<input type="number" name="week" style="width: 40px"></td>
                <td><label>Даты: </label>&nbsp;<input type="number" name="dates1" style="width: 40px"></td>
                <td><label> - </label>&ensp;<input type="date" name="dates2"></td>
                <td><label> Отображение </label> <input type="checkbox" name="check_show"></td>
                <td><button class="btn btn-lg btn-primary btn-block" type="submit">Изменить</button></td>
            </tr>
        </form>
        </sec:authorize>
    </table>
    <label>Ткущая дата ВЫПЛАТ: ${date} | Неделя: ${tmp_fin_date.week} | Даты: ${tmp_fin_date.dates} | Показывать - ${show}</label>
</div>

    <table class="table table-striped">
        <thead>
        <th>Сотрудник</th>
        <th>Код</th>
        </thead>
        <c:forEach items="${allUser}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.driver_code}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/get_user_fin_id" method="post">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Смотреть</button>
                    </form>
                </td>
                <td>
                    <sec:authorize access="hasRole('ROLE_FIN')">
                    <form action="${pageContext.request.contextPath}/fin_edit" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Измения</button>
                    </form>
                    </sec:authorize>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>