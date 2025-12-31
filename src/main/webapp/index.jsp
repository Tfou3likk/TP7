<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.univ.tours.jakartaee.tp6.business.pojo.User" %>

<!DOCTYPE html>
<html>
<head>
    <title>VinylMarketEJB</title>
</head>
<body>
    <h2>Bonjour, veuillez vous connecter en renseignant votre email :
        <form action="${pageContext.request.contextPath}/login" method="post">
            <input type="text" name="email" required/>
            <input type="submit" value="Se connecter"/>
        </form>
    <h2>
    <c:if test="${loginFailure}">
        <p style="color: red">Email ou mot de passe incorrect</p>
    </c:if>
    <a href="${pageContext.request.contextPath}/signup.jsp"><button>Créer un compte</button></a>
</body>
</html>