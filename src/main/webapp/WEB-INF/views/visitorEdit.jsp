<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>Edycja pracownika</title>
</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-header">Edytuj pracownika:  ${visitor.fullName}</div>
        <div class="card-body">
            <form:form method="post" modelAttribute="visitor">
                <div class="form-row">
                    <div class="col">
                        <form:input path="firstName" class="form-control"/>
                    </div>
                    <div class="col">
                        <form:input path="lastName" class="form-control"/>
                    </div>
                    <div class="col" style="display: none;">
                        <form:input path="company" class="form-control" value="${company.id}" readonly="true"/>
                    </div>
                    <div class="col" style="display: none;">
                        <form:input path="id" class="form-control" value="${visitor.id}" readonly="true"/>
                    </div>
                    <div class="col">
                        <form:select path="file" class="form-control">
                            <form:options items="${files}" itemLabel="fileName" itemValue="id"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-secondary" type="submit">Zmień</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
