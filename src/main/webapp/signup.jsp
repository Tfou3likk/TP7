<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Création d'un utilisateur</title></head>
<body>
    <h1>Créer un nouvel utilisateur</h1>
    <form method="post" action="${pageContext.request.contextPath}/signup">
        <label>Email</label>
        <input type="text" name="email"/>
        <br/>
        <label>Prénom</label>
        <input type="text" name="firstname"/>
        <br/>
        <label>Nom</label>
        <input type="text" name="lastname"/>
        <br/>
        <input type="submit" value="Enregister & se connecter"/>
    </form>
    <c:if test="${signupFailure}">
        <p style="color: red">Une erreur s'est glissé dans le formulaire ou l'utilisateur existe déjà</p>
    </c:if>
    <a href="${pageContext.request.contextPath}/"><button>Retour à la connexion</button></a>
</html>
