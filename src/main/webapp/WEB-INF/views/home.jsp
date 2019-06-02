<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>Access Control List</title>

    <link href='<c:url value="/resources/css/core/main.css"/>' rel='stylesheet' />
    <link href='<c:url value="/resources/css/daygrid/main.css"/>' rel='stylesheet' />
    <link href='<c:url value="/resources/css/timegrid/main.css"/>' rel="stylesheet">
    <link href='<c:url value="/resources/css/list/main.css" />' rel="stylesheet">
    <link href='<c:url value="/resources/css/bootstrap/main.css"/>' rel="stylesheet">

    <script src='<c:url value="/resources/js/core/main.js"/>'></script>
    <script src='<c:url value="/resources/js/daygrid/main.js"/>'></script>
    <script src='<c:url value="/resources/js/interaction/main.js"/>'></script>
    <script src='<c:url value="/resources/js/timegrid/main.js"/>'></script>
    <script src='<c:url value="/resources/js/list/main.js" />'></script>
    <script src='<c:url value="/resources/js/core/locales/pl.js" />'></script>
    <script src='<c:url value="/resources/js/bootstrap/main.js" />'></script>
    <script src='<c:url value="/resources/js/homePage/home.js" />'></script>

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
                }
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
                Dodaj wizytę
            </button>
        </div>
        <div class="collapse" id="collapseExample">
            <form:form method="post" modelAttribute="visit">
                <div class="form-row">
                    <div class="col">
                        <label for="companySelect">Wybierz firmę: </label>
                        <form:select path="visitor.company" id="companySelect">
                            <form:option value="-" label="Firma"/>
                            <form:options items="${companies}" itemLabel="name" itemValue="id"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <label for="visitorSelect">Wybierz pracownika :</label>
                        <form:select path="visitor" id="visitorSelect">
                            <form:options items="${visitors}" itemLabel="fullName" itemValue="id"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-secondary" type="submit">Dodaj</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<div id='calendar' class="container"></div>

</body>
</html>
