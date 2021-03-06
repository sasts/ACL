<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://momentjs.com/downloads/moment.js"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">

    <%-- DateTimePicker Bootstrap --%>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/js/tempusdominus-bootstrap-4.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/css/tempusdominus-bootstrap-4.min.css"/>
    <script src='<c:url value="/resources/js/datetimepicker/pl.js"/>'></script>

    <%-- Home icon --%>
    <script src="https://kit.fontawesome.com/fce436e993.js"></script>

    <%-- my CSS --%>
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">

    <title>Access Control List</title>

    <%-- FullCalendar Bootstrap --%>
    <link href='<c:url value="/resources/css/core/main.css"/>' rel='stylesheet' />
    <link href='<c:url value="/resources/css/daygrid/main.css"/>' rel='stylesheet' />
    <link href='<c:url value="/resources/css/timegrid/main.css"/>' rel="stylesheet">
    <link href='<c:url value="/resources/css/list/main.css"/>' rel="stylesheet">
    <link href='<c:url value="/resources/css/bootstrap/main.css"/>' rel="stylesheet">

    <script src='<c:url value="/resources/js/core/main.js"/>'></script>
    <script src='<c:url value="/resources/js/daygrid/main.js"/>'></script>
    <script src='<c:url value="/resources/js/interaction/main.js"/>'></script>
    <script src='<c:url value="/resources/js/timegrid/main.js"/>'></script>
    <script src='<c:url value="/resources/js/list/main.js" />'></script>
    <script src='<c:url value="/resources/js/core/locales/pl.js"/>'></script>
    <script src='<c:url value="/resources/js/bootstrap/main.js"/>'></script>
    <script src='<c:url value="/resources/js/homePage/home.js"/>'></script>

    <script>

        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                locale: 'pl',
                plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list', 'bootstrap'],
                defaultView: 'dayGridMonth',
                themesystem: 'bootstrap',
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
                },
                events: [
                    {
                        title: 'JAVA',
                        start: '2019-06-08',
                        allDay: true,
                    },

                ],

            });

            calendar.render();

        });

    </script>

</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-body">
            <button class="btn btn-outline-secondary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Zarejestruj gościa
            </button>
        </div>
        <div class="collapse" id="collapseExample">
            <form:form method="post" modelAttribute="visit" action="/home">
                <div class="form-row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <div class="input-group date" id="datetimepicker2" data-target-input="nearest">
                                <form:input path="logIn" class="form-control datetimepicker-input" data-target="#datetimepicker2" value="" id="in"/>
                                <div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <form:select path="area.id" class="form-control" id="areaSelect">
                            <form:option value="-" label="Wybierz cel:"/>
                            <form:options items="${areas}" itemLabel="name" itemValue="id"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col">
                        <form:select path="company.id" id="companySelect" class="form-control">
                            <form:option value="-" label="Wybierz firmę:"/>
                            <form:options items="${companies}" itemLabel="name" itemValue="id"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <form:select path="visitor.id" id="visitorSelect" class="form-control">
                            <option value="-">Pracownicy</option>
                            <form:options items="${visitors}" itemLabel="fullName" itemValue="id"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-secondary" type="submit">Dodaj</button>
                    </div>
                </div>
            </form:form>
        </div>
        <div class="card-body">
            <button class="btn btn-outline-secondary" type="button" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample">
                Lista obecnych gości
            </button>
        </div>
        <div class="collapse" id="collapseExample2">
            <table class="table table-hover">
                <tr>
                    <th>Imię i nazwisko</th>
                    <th>Firma</th>
                    <th>Miejsce</th>
                    <th>Godzina wejścia</th>
                </tr>
                <c:forEach items="${visitsIn}" var="vIn">
                    <tr>
                        <td width="20%" style="text-align:center;">${vIn.visitor.fullName}</td>
                        <td width="20%" style="text-align:center;">${vIn.company.name}</td>
                        <td width="20%" style="text-align:center;">${vIn.area.name}</td>
                        <td width="20%" style="text-align:center;">${vIn.logIn.hour} : ${vIn.logIn.minute}</td>
                        <td width="20%" style="text-align:center;">
                            <a href="/visit/edit/${vIn.id}" class="btn btn-outline-secondary">Wyrejestruj</a>
                            <a href="/visit/delete/${vIn.id}" class="btn btn-outline-secondary">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<div id='calendar' class="container"></div>

</body>
</html>
