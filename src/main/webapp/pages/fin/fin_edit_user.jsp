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

  <title>EditFinData</title>
  <style>
    <%@include file='/pages/css/bootstrap.css' %>
    <%@include file='/pages/css/signin.css' %>
  </style>
</head>

<body>
<div class="container" style="width: 300px;">

    <form:form  method="POST" action="/fin_add_data" modelAttribute="finForm" >
        <div>
            <h2 style="text-align: center;" class="form-signin-heading">Редактирование данных пользователя:</h2>
            <h2 style="text-align: center;" class="form-signin-heading">${user.username} </h2>
        </div>

        <form:input class="form-control"  type="hidden" path="id" value="${finForm.id}"></form:input>
        <form:label  path="bonus">Вал:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="val" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Доп. доход:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="dop_dohod" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Расчет. топливо:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="toplivo" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Расчетная сумма:</form:label>
        <div>
            <form:input class="form-control"  type="number" step="0.01" path="sum_val_dop_d_top" placeholder="0.00/2 (*)" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Переплата:</form:label>
        <div>
            <form:input class="form-control"  type="text"  path="pereplata_nal" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Название бонуса:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="bonus" placeholder="бонусы за:" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Сумма бонуса:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="sum_bonus" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Перенесено:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="pred_week" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Перерасход:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="pererashod" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Недосдача:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="nedosdacha" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Мойка:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="moyka" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Даты авансов:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="date_avans" placeholder="01.01" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Авансы:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="avans" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Какие выплаты:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="data_vyplaty" placeholder="телефон, франшиза и т.п." autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Выплаты:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="vyplaty" placeholder="телефон, франшиза и т.п." autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Другое:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="drugoe" placeholder="другое" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">Другое(сумма):</form:label>
        <div>
            <form:input class="form-control"  type="text" path="sum_drugoe" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <form:label  path="bonus">ИТОГО:</form:label>
        <div>
            <form:input class="form-control"  type="text" path="itogo" placeholder="0.00" autofocus="true"></form:input>
        </div>

        <div>
            <form:label  path="bonus">Показать:</form:label> <form:checkbox class="form-control" path = "show" />
        </div>
        <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px" type="submit">Сохранить</button>

    </form:form>

    <p> <a class="btn btn-lg btn-success btn-block" style="margin-top: 10px" href="<c:url value="/fin_edit" />" role="button">Отменить</a> </p>
    <p> <a class="btn btn-lg btn-success btn-block" href="<c:url value="/" />" role="button">Главная</a></p>
</div>
</body>
</html>