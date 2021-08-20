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
<div class="container" style="position: center">
    <p><a class="btn btn-lg btn-success" href="<c:url value="/admin" />" role="button">Панель</a>
        <a class="btn btn-lg btn-danger" href="<c:url value="/" />" role="button">Главная</a></p>

    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>UserName</th>
        <th>Email</th>
        <th>Driver code</th>
        <th>Phone number</th>
        <th>Kurator</th>
        </thead>
        <c:forEach items="${allEditUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.driver_code}</td>
                <td>${user.pone_number}</td>
                <td>${user.kurator}</td>

                <td>
                    <form action="${pageContext.request.contextPath}/update_user" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
                    </form>
                </td>

                <td>
                    <form action="${pageContext.request.contextPath}/edit_user/id" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
                    </form>
                </td>

                <td>
                    <form action="${pageContext.request.contextPath}/reset_pass/id" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Pass</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>