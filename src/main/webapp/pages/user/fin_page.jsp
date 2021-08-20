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

  <title>Финансы</title>
  <style>
    <%@include file='/pages/css/jumbotron-narrow.css' %>
    <%@include file='/pages/css/bootstrap.css' %>
    .cell1 {
      text-align: left;
      font-size: 15px;
      font-weight: bold;
    }
    .cell2 {
      font-weight: bold;
      font-size: 17px;

    }
    tr {
      border-bottom-style: groove;
    }
  </style>
</head>

<body>

<div class="container">
  <div class="jumbotron">
    <h3 style="text-align: center;" class="form-signin-heading">ВЫПЛАТА от ${fin_tmp_date.date}  </h3>
    <h3 style="text-align: center;" class="form-signin-heading">неделя: ${fin_tmp_date.week} </h3>
    <h3 style="text-align: center;" class="form-signin-heading">даты: ${fin_tmp_date.dates} </h3>

    <label>${name}</label>
    <br>
<div style="display: inline-block;">

    <table>

      <colgroup>
        <col span="1" style="width: 70% ">
        <col style="width: 30% ">
      </colgroup>
      <tr>
        <td class="cell1">ВАЛ:</td>
        <td class="cell2">${FinData.val} грн</td>
      </tr>
      <tr >
        <td class="cell1">+ доп.доход:</td>
        <td class="cell2">${FinData.dop_dohod} грн</td>
      </tr>
      <tr>
        <td class="cell1">- расчетное топливо:</td>
        <td class="cell2">${FinData.toplivo} грн</td>
      </tr>
      <tr style="border-bottom-style: dashed;">
        <td class="cell1">= ${FinData.sum_val_dop_d_top} / 2 =</td>
        <td class="cell2">${raz_sum} грн</td>
      </tr>
      <tr>
        <td>&ensp;&ensp;&ensp;&ensp;&ensp;
          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
          &ensp;&ensp;&ensp;&ensp;&ensp;</td>
        <td>&ensp;</td>
      </tr>
      ${pereplata}
<%--      <tr>--%>
<%--        <td class="cell1">+ переплата:</td>--%>
<%--        <td class="cell2">${FinData.pereplata_nal} грн</td>--%>
<%--      </tr>--%>
      ${bonus}
<%--      <tr>--%>
<%--        <td class="cell1">+ бонусы за ${FinData.bonus}:</td>--%>
<%--        <td class="cell2">${FinData.sum_bonus} грн</td>--%>
<%--      </tr>--%>
      ${pereneseno}
<%--      <tr>--%>
<%--        <td class="cell1">+ перенесено с предыдущей недели:</td>--%>
<%--        <td class="cell2">${FinData.pred_week} грн</td>--%>
<%--      </tr>--%>
      ${pererazhod}
<%--      <tr>--%>
<%--        <td class="cell1">- перерасход топлива:</td>--%>
<%--        <td class="cell2">${FinData.pererashod} грн</td>--%>
<%--      </tr>--%>
      ${nedozdacha}
<%--      <tr>--%>
<%--        <td class="cell1">- недосдача:</td>--%>
<%--        <td class="cell2">${FinData.nedosdacha} грн</td>--%>
<%--      </tr>--%>
      ${moyka}
<%--      <tr>--%>
<%--        <td class="cell1">- мойка авто:</td>--%>
<%--        <td class="cell2">${FinData.moyka} грн</td>--%>
<%--      </tr>--%>
      ${avans}
<%--      <tr>--%>
<%--        <td class="cell1">- аванс: ${FinData.date_avans} </td>--%>
<%--        <td class="cell2">${FinData.avans} грн</td>--%>
<%--      </tr>--%>
      ${vyplata}
<%--      <tr>--%>
<%--        <td class="cell1">- выплаты: ${FinData.data_vyplaty}</td>--%>
<%--        <td class="cell2">${FinData.vyplaty} грн</td>--%>
<%--      </tr>--%>
      ${drugoe}
<%--      <tr>--%>
<%--        <td class="cell1">- другое: ${FinData.drugoe}</td>--%>
<%--        <td class="cell2">${FinData.sum_drugoe} грн</td>--%>
<%--      </tr>--%>

    </table>
</div>

  <br>
    <label>ИТОГО к получению: ${FinData.itogo} грн</label>
  <br>
    <p><a style="width: 200px;" class="btn btn-lg btn-success" href="<c:url value="/"/>" role="button">Выход</a></p>
  </div>
  <div class="footer">
    <p>&copy; Center City</p>
  </div>
</div>
</body>
</html>