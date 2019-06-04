<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
    <title>Pracownicy</title>
</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-body">
            <button class="btn btn-outline-secondary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Dodaj pracownika
            </button>
            <a class="btn btn-outline-secondary" href="/company" role="button">Wróć to listy firm</a>
        </div>
        <div class="collapse" id="collapseExample">
            <form:form method="post" modelAttribute="visitor" action="/company/visitors/{companyId}" enctype="multipart/form-data">
                <div class="form-row">
                    <div class="col">
                        <form:input path="firstName" class="form-control" placeholder="Imię" aria-label="Imię"/>
                    </div>
                    <div class="col">
                        <form:input path="lastName" class="form-control" placeholder="Nazwisko" aria-label="Nazwisko"/>
                    </div>
                    <div class="col"  style="display: none;">
                        <form:input path="company" class="form-control" value="${company.id}" readonly="true"/>
                    </div>
                    <div class="col">
                        <form:select path="file" class="form-control">
                            <form:option value="-" label="Wybierz"/>
                            <form:options items="${files}" itemLabel="fileName" itemValue="id"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-secondary" type="submit">Dodaj</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Pracownicy ${company.name}</th>
                    <th>Lista dostępu</th>
                </tr>
                <c:forEach items="${visitors}" var="vis">
                    <tr>
                        <td width="60%">${vis.fullName}</td>
                        <td width="20%">${vis.file.fileName}</td>
                        <td width="20%">
                            <a href="/company/visitors/${company.id}/edit/${vis.id}" class="btn btn-outline-secondary">Edytuj</a>
                            <a href="/company/visitors/${company.id}/delete/${vis.id}" class="btn btn-outline-secondary">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
