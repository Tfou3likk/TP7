<%@ page language="java"  contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Panier</title>
</head>
<body>
<h1>Voici votre panier</h1>
<table class="basket-table" style="margin: 20px">
    <thead>
    <tr>
        <th id="ref">Référence</th>
        <th id="album">Album</th>
        <th id="artist">Artiste</th>
        <th id="price">Prix</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${basket}" var="diskToBy">
        <tr>
            <td>${diskToBy.disk().identificationCode()}</td>
            <td>${diskToBy.disk().album()}</td>
            <td>${diskToBy.disk().artist()}</td>
            <td>${diskToBy.price()}</td>
            <td>
                <form action="${pageContext.request.contextPath}/basket" method="post">
                    <input type="hidden" name="diskReference" value="${diskToBy.disk().identificationCode()}"/>
                    <input type="hidden" name="action" value="remove"/>
                    <input type="submit" value="Retirer du panier"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    <c:if test="submitFailure">
        <p style="color: red">La commande a rencontré des problèmes certains articles ne sont plus disponibles</p>
    </c:if>
    </tbody>
</table>

<table>
    <tbody>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/marketplace" method="get"><input type="submit"
                                                                                              value="Continuer mes achats"/>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/basket" method="post">
                <input type="hidden" name="action" value="submit"/>
                <input type="submit" value="Passer commande"/>
            </form>
        </td>
    </tr>
    </tbody>
</table>
</body>
<style>
    .basket-table {
        border: 1px double black;
        border-collapse: separate;
        border-spacing: 1px;
    }

    .basket-table th, .basket-table td {
        border: 1px double black;
        padding: 8px;
        text-align: left;
    }
</style>
</html>
