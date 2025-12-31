<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.univ.tours.jakartaee.tp6.business.pojo.User" %>

<!DOCTYPE html>
<html>
<head>
    <title>VinylMarketEJB</title>
</head>
<body>
    <h2>Bonjour ${sessionScope.user.firstName()} ${sessionScope.user.lastName()}</h2>
    <h1>Voici votre collection</h1>
    <table style="margin: 20px">
        <thead>
        <tr>
            <th id="ref">Référence</th>
            <th id="album">Album</th>
            <th id="artist">Artiste</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${collection}" var="disk">
            <tr>
                <td>${disk.identificationCode()}</td>
                <td>${disk.album()}</td>
                <td>${disk.artist()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/marketplace"><button>Acheter de nouveaux disques</button></a>
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