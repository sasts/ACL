<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://kit.fontawesome.com/fce436e993.js"></script>
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
    <title>Header</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark" style="background-color: #e3f2fd;" charset="UTF-8">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/home"/>"><i class="fas fa-server"></i>Data Center</a><a class="navbar-brand" href="/home"><i class="fas fa-home fa-lg" class="navbar-brand"></i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <a class="nav-link active" href="/company"><i class="far fa-building"></i>Firmy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/areas"><i class="fas fa-map-marked-alt"></i>Miejsca</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/files/list"><i class="far fa-file-alt"></i>Aktulane listy dostępu</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
