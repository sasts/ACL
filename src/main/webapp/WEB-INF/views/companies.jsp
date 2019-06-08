<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
    <title>Lista firm</title>
    <script>
        function confirmDeleteCompany(id, name) {
            if (confirm("Czy chcesz usunąć firmę \"" + name + "\"? Spowoduje to usunięcie pracowników, list dostępu i wizyt.")) {
                window.location.href = "/company/delete/" + id;
            }
        }
    </script>
</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-body">
            <button class="btn btn-outline-secondary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Dodaj firmę
            </button>
        </div>
        <div class="collapse" id="collapseExample">
            <form:form method="post" modelAttribute="company">
                <div class="input-group mb-3">
                    <form:input path="name" class="form-control" placeholder="Nazwa firmy" aria-label="Nazwa firmy" aria-describedby="button-addon2"/>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Dodaj</button>
                    </div>
                </div>
                <form:errors path="name" element="div" cssClass="text-danger" cssStyle="padding-left: 10px"/>
            </form:form>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Firmy</th>
                </tr>
                <c:forEach items="${companies}" var="comp">
                    <tr>
                        <td width="80%"><a href="/company/visitors/${comp.id}"><i class="fas fa-users"></i>${comp.name}</a></td>
                        <td width="20%">
                            <a href="/company/edit/${comp.id}" class="btn btn-outline-secondary">Edytuj</a>
                            <a href="#" onclick="confirmDeleteCompany(${comp.id}, '${comp.name}')" class="btn btn-outline-secondary">Usuń</a><br>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
