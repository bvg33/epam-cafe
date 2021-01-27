<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 02.01.2021
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order</title>
    <link href="${pageContext.request.contextPath}/static/styles/order.css" type="text/css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
</head>
<body>
<jsp:include page="templates/adminSidebar.jsp"/>
<jsp:include page="templates/menuTemplate.jsp"/>
<fmt:message bundle="${loc}" key="locale.removeAlert" var="alert"/>
<fmt:message bundle="${loc}" key="locale.removeFromMenuButton" var="removeFromMenuButton"/>
<input type="hidden" class="alertMessage" value="${alert}">
<input type="hidden" class="btnText" value="${removeFromMenuButton}">
<input type="hidden" class="command" value="removeFromMenu">
<script src="${pageContext.request.contextPath}/static/js/Pagination.js"></script>
</body>
</html>
