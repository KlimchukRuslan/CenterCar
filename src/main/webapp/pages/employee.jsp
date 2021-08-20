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
        ${date}

        <form:form method="post" modelAttribute="employee">

            <table style="width: 100%; margin-bottom: 10px" >
                <tr style="height: 50px">
                    <td style="width: 30%; margin-left: 10px; border-bottom-style: groove">
                        <label>Принимает:</label>
                    </td>
                    <td style="width: 70%; text-align: -webkit-right; border-bottom-style: groove">
                        <p><sec:authentication property="principal.username" /></p>
                    </td>
                </tr>
                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: groove">
                        <form:label  path="car_number">Номер авто</form:label>
                    </td>
                    <td style="width: 30%; text-align: -webkit-right; border-bottom-style: groove" >
                        <form:select cssStyle="width: 120px" class="form-control"  path="car_number">
                            <form:options items="${carNumber}" />
                        </form:select>
                    </td>
                </tr>

                <tr style="height: 50px">
                    <td style="width: 40%; margin-left: 10px; border-bottom-style: solid">
                        <form:label path="probeg">Пробег</form:label>
                    </td>
                    <td style="width: 30%; text-align: -webkit-right; border-bottom-style: solid" >
                        <form:input cssStyle="width: 120px; text-align: center" class="form-control" path="probeg" />
                    </td>
                </tr>
            </table>



            <table style="width: 100%; text-align: left" class="table table-striped">
                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "oilCheck">Уровень масла</form:label>
                    </td>
                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "oilCheck" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; border-bottom-style: dashed; margin-left: 10px">
                        <form:label path="fluid_level">Уровни жидкостей</form:label>
                    </td>
                    <td style="width: 52px; vertical-align: middle; border-bottom-style: dashed; height: 52px">
                        <form:checkbox class="form-control" path = "fluid_level" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "salon">Состояние салона</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "salon" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; border-bottom-style: dashed; margin-left: 10px">
                        <form:label path = "car_rubber">Состояние резины</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; border-bottom-style: dashed; height: 52px">
                        <form:checkbox class="form-control" path = "car_rubber" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "lighting">Освещение</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "lighting" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "car_insurance">Страховка</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "car_insurance" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; border-bottom-style: dashed; margin-left: 10px">
                        <form:label path = "car_certificate">Тех.паспорт</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; border-bottom-style: dashed; height: 52px">
                        <form:checkbox class="form-control" path = "car_certificate" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "zapaska">Запаска</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "zapaska" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "domkrat">Домкрат</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "domkrat" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "balonik">Бал. ключ</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "balonik" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "kruck">Букс. крюк</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "kruck" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "tros">Букс. трос</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "tros" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "ognetushitel">Огнетушитель</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "ognetushitel" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "zeletka">Жилетка</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "zeletka" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "aptechka">Аптечка</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "aptechka" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "znak_avar">Знака авар. ост.</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox class="form-control" path = "znak_avar" />
                    </td>
                </tr>

                <tr>
                    <td style="width: 85%; height: 52px; vertical-align: middle; margin-left: 10px">
                        <form:label path = "protiviotkat">Противооткат</form:label>
                    </td>

                    <td style="width: 52px; vertical-align: middle; height: 52px">
                        <form:checkbox  class="form-control" path = "protiviotkat" />
                    </td>
                </tr>

            </table>

            <p style="text-align: -webkit-center">
                <button style="width: 200px"  class="btn btn-lg btn-primary btn-block"  type="submit">Принять</button>
            </p>
            <p style="text-align: -webkit-center">
                <a style="width: 200px;" class="btn btn-lg btn-success btn-block"  href="<c:url value="/" />" role="button">Отменить</a> </p>

        </form:form>
    </sec:authorize>
</div>

</body>
</html>
