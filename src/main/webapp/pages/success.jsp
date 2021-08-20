<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
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

        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
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
        ${date}

        <form:form method="post" modelAttribute="employee">

            <table style="width: 100%; margin-bottom: 10px" >
                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <form:label  path="car_number" >TC:</form:label>
                    </td>
                    <td style="width: 30%; text-align: -webkit-right; border-bottom-style: groove" >
                        <form:label  path="car_number">${employee.car_number}</form:label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <form:label  path="probeg" >Пробег:</form:label>
                    </td>
                    <td style="width: 30%; text-align: -webkit-right; border-bottom-style: groove" >
                        <form:label  path="car_number">${employee.probeg}</form:label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 30%; margin-left: 10px; border-bottom-style: solid">
                        <label>Сдаёт ТС:</label>
                    </td>
                    <td style="width: 70%; text-align: -webkit-right; border-bottom-style: solid">
                        <form:label  path="old_driver_email">${employee.old_name_worker}</form:label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <label>Запаска:</label>
                    </td>
                    <td style="width: 30%; text-align: -webkit-right; border-bottom-style: groove" >
                        <label>${t_zapaska}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 30%; margin-left: 10px; border-bottom-style: groove">
                        <label>Домкрат:</label>
                    </td>
                    <td style="width: 70%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${t_domkrat}</label>

                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 30%; margin-left: 10px; border-bottom-style: groove">
                        <label>Огнетушитель:</label>
                    </td>
                    <td style="width: 70%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${ognetushitel}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <label>Балонный ключ:</label>
                    </td>
                    <td style="width: 60%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${balonik}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <label>Буксировочный трос:</label>
                    </td>
                    <td style="width: 60%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${tros}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 30%; margin-left: 10px; border-bottom-style: groove">
                        <label>Жилетка:</label>
                    </td>
                    <td style="width: 70%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${zhiletka}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 30%; margin-left: 10px; border-bottom-style: groove">
                        <label>Аптечка:</label>
                    </td>
                    <td style="width: 70%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${aptechka}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <label>Буксировочный крюк:</label>
                    </td>
                    <td style="width: 60%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${kruk}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 30%; margin-left: 10px; border-bottom-style: groove">
                        <label>Противооткат:</label>
                    </td>
                    <td style="width: 70%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${potkat}</label>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <label>Знак аварийки:</label>
                    </td>
                    <td style="width: 60%; text-align: -webkit-right; border-bottom-style: groove">
                        <label>${znak}</label>
                    </td>
                </tr>
            </table>

            <div style="text-align: -webkit-center">
                <form:input type="text" pattern="[0-9]{4}" cssStyle="width: 200px; height: 45px; text-align: center; font-size: 30px" path="code" ></form:input>
                <form:errors path="code"></form:errors>
                    ${codeError}
            </div>
            <p style="text-align: -webkit-center">
                <label>Код для сдачи автомобиля отправлен на почтовый адрес:</label>
                <label>${employee.old_driver_email}</label>
            </p>

            <p style="text-align: -webkit-center">
                <button style="width: 200px"  class="btn btn-lg btn-primary btn-block"  type="submit">Сдать</button>
            </p>
            <%--            <p style="text-align: -webkit-center">--%>
            <p style="text-align: -webkit-center"><a style="width: 200px;" class="btn btn-lg btn-danger" href="javascript:history.go(-1)" role="button">Назад</a></p>
        </form:form>
    </sec:authorize>
</div>

</body>
</html>