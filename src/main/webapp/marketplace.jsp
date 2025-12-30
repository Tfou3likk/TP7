<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Marketplace</title>
</head>
<body>
<h1>Stock disponible à l'achat</h1>
<a href="${pageContext.request.contextPath}/basket"><button>Consulter mon panier</button></a>

<table style="margin: 20px">
    <thead>
        <tr>
            <th id="ref">Référence</th>
            <th id="album">Album</th>
            <th id="artist">Artiste</th>
            <th id="price">Prix</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${stock}" var="diskToSold">
            <tr>
                <td>${diskToSold.disk().identificationCode()}</td>
                <td>${diskToSold.disk().album()}</td>
                <td>${diskToSold.disk().artist()}</td>
                <td>${diskToSold.price()}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/basket" method="post">
                        <input type="hidden" name="diskReference" value="${diskToSold.disk().identificationCode()}"/>
                        <input type="hidden" name="action" value="add"/>
                        <input type="submit" value="Ajouter au panier"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/home"><button>Retour</button></a>
</body>
<style>
    table {
        border: 1px double black;
        border-collapse: separate;
        border-spacing: 1px;
    }

    th, td {
        border: 1px double black;
        padding: 8px;
        text-align: left;
    }
</style>
</html>
