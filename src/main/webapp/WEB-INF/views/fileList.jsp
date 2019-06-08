<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
    <script>
        function confirmDelete(id, name) {
            if (confirm("Czy chcesz usunąć plik \"" + name + "\"? " + '\n' +
                "Sprawdź czy lista została odłączona od pracowników.")) {
                window.location.href = "/files/delete/" + id;
            }
        }
    </script>
    <title>Listy dostępu</title>
</head>
<body>

<%@include file="header.jsp"%>

<div class="container">

    <div class="card">
        <div class="card-body">
            <button class="btn btn-outline-secondary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Dodaj listę
            </button>
        </div>
        <div class="collapse" id="collapseExample">
            <form:form method="post" action="/files/list" enctype="multipart/form-data" modelAttribute="file">
                <div class="form-row">
                    <div class="col">
                        <form:select path="company" id="companySelect" class="form-control">
                            <form:option value="-" label="Wybierz firmę"/>
                            <form:options items="${companies}" itemLabel="name" itemValue="id"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <input type="file" name="file" id="file"/>
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-secondary center-pill" type="submit">Dodaj</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Firma</th>
                    <th>Listy</th>
                </tr>
                <c:forEach items="${companies}" var="comp">
                    <tr>
                        <td width="40%">${comp.name}</td>
                        <td width="40%">
                            <c:forEach items="${comp.files}" var="fil">
                                ${fil.fileName}<br><br>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${comp.files}" var="fil">
                                <a href="/files/download/${fil.id}" class="btn btn-outline-secondary btn-sm">Pobierz</a>
                                <a href="#" onclick="confirmDelete(${fil.id}, '${fil.fileName}')" class="btn btn-outline-secondary btn-sm">Usuń</a><br>
                            </c:forEach>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
