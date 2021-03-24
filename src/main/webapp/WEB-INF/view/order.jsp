<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 13.11.2020
  Time: 14:57
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
<jsp:include page="templates/sidebar.jsp"/>
<jsp:include page="templates/menuTemplate.jsp"/>
<fmt:message bundle="${loc}" key="locale.alertMessage" var="alert"/>
<fmt:message bundle="${loc}" key="locale.addToOrderBtn" var="addToOrderBtnText"/>
<input type="hidden" class="alertMessage" value="${alert}">
<input type="hidden" class="btnText" value="${addToOrderBtnText}">
<input type="hidden" class="command" value="addToBucket">
<script src="${pageContext.request.contextPath}/static/js/Pagination.js"></script>
</body>
</html>