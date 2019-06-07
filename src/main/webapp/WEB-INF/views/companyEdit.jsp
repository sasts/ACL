<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
    <title>Edycja firmy</title>
</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-header">Edytuj firmę ${company.name}</div>
        <div class="card-body">
            <form:form method="post" modelAttribute="company">
                <div class="input-group mb-3">
                    <form:input path="name" class="form-control" aria-describedby="button-addon2"/>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Zmień</button>
                    </div>
                </div>
                <form:errors path="name" element="div" cssClass="text-danger" cssStyle="padding-left: 10px"/>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
