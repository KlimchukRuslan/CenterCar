<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<% List list = (List)session.getAttribute("carList");
    request.setAttribute("list", list);
%>


<html>
<head>
    <title>renault</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>


<sec:authorize access="!isAuthenticated()">
    <h2>Для доступа к этой странице Вам нужно авторизоватся</h2>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p>Ваш логин: <sec:authentication property="principal.username" /></p>
    <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
    <p><a class="btn btn-lg btn-danger" href="<c:url value="/" />" role="button">Главная</a></p>

    <form action="${pageContext.request.contextPath}/car" method="post">
        <input type="submit" name="button1" value="Get Data" />
        <input type="submit" name="button2" value="Clear!!!" />

        <th><input id="datetimeone" type="datetime-local" name="dateOne"></th>
        <th><input id="datetimetwo" type="datetime-local" name="dateTwo"> ></th>

        <table class="table table-striped">
            <c:forEach items="${car_list}" var="entry">
                <tr>
                    <td>${entry.car_number}</td>
                    <td><c:out value="${entry.id_tracer}" /></td>
                    <td><c:out value="${entry.prob}" /></td>
                </tr>
            </c:forEach>
        </table>
    </form>

</sec:authorize>

</body>
</html>
