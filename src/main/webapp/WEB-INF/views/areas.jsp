<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
    <title>Miejsca</title>
</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-body">
            <button class="btn btn-outline-secondary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Dodaj miejsce
            </button>
        </div>
        <div class="collapse" id="collapseExample">
            <form:form method="post" modelAttribute="area" id="areaForm">
                <div class="input-group mb-3">
                    <form:input path="name" class="form-control" placeholder="Nazwa miejsca" aria-label="Nazwa miejsca" aria-describedby="button-addon2"/>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Dodaj</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Miejsca</th>
                </tr>
                <c:forEach items="${areas}" var="ar">
                    <tr>
                        <td width="80%">${ar.name}</td>
                        <td width="20%">
                            <a href="/areas/edit/${ar.id}" class="btn btn-outline-secondary">Edytuj</a>
                            <a href="/areas/delete/${ar.id}" class="btn btn-outline-secondary">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
