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
    <script src='<c:url value="/resources/js/homePage/home.js"/>'></script>

    <%-- Home icon --%>
    <script src="https://kit.fontawesome.com/fce436e993.js"></script>

    <title>Edycja wizyty</title>
</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-header">Wyrejestruj: ${visitOut.visitor.fullName}</div>
        <div class="card-body">
            <form:form method="post" modelAttribute="visitOut">
                <div class="form-row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <div class="input-group date" id="datetimepicker3" data-target-input="nearest">
                                <form:input path="logOut" class="form-control datetimepicker-input" data-target="#datetimepicker3" value="" id="out"/>
                                <div class="input-group-append" data-target="#datetimepicker3" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group" style="display: none;">
                            <form:input path="logIn" class="form-control datetimepicker-input" data-target="#datetimepicker2" value="" id="in"/>
                        </div>
                    </div>
                    <div class="col-sm-4" style="display: none;">
                        <form:input path="area.id" value="${visitOut.area.id}"/>
                    </div>
                </div>
                <div class="form-row" style="display: none;">
                    <div class="col">
                        <form:input path="company.id" value="${visitOut.company.id}"/>
                    </div>
                    <div class="col" style="display: none;">
                        <form:input path="visitor.id" value="${visitOut.visitor.id}"/>
                    </div>
                    <div class="col" style="display: none;">
                        <form:input path="id" value="${visitOut.id}"/>
                    </div>
                </div>
                <div class="col">
                    <button class="btn btn-outline-secondary" type="submit">Wyrejestruj</button>
                    <a href="<c:url value="/home"/>" class="btn btn-outline-secondary">Anuluj</a>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script>

    function setDate() {
        var dateFromDB = $("#in").val();
        var dateToDB = moment(dateFromDB).format("YYYY-MM-DD HH:mm").toString();
    }

    function setInVAlue() {
        $("#in").value = setDate();
    }

</script>

</body>
</html>
