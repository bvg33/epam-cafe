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
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/sidebar.jsp"/>
<div class="workplace">
    <div class="page-info">
        <table id="table">
        </table>
        <ul id="pagination"></ul>
    </div>
</div>
<c:forEach var="menu" items="${sessionScope.menuList}">
    <input type="hidden" class="allNames" value="${menu.getName()}"/>
    <input type="hidden" class="allPrice" value="${menu.getPrice()}"/>
    <input type="hidden" class="allDescriptions" value="${menu.getDescription()}"/>
    <input type="hidden" class="allPhotos" value="${menu.getPhoto()}"/>
</c:forEach>
<fmt:message bundle="${loc}" key="locale.addToOrderBtn" var="addToOrderBtnText"/>
<fmt:message bundle="${loc}" key="locale.tableColoumnName" var="name"/>
<fmt:message bundle="${loc}" key="locale.tableColoumnPrice" var="price"/>
<fmt:message bundle="${loc}" key="locale.tableColoumnDescription" var="description"/>
<fmt:message bundle="${loc}" key="locale.tableColoumnPhoto" var="photo"/>
<input type="hidden" class="addToOrderBtnText" value="${addToOrderBtnText}">
<input type="hidden" class="name" value="${name}">
<input type="hidden" class="price" value="${price}">
<input type="hidden" class="description" value="${description}">
<input type="hidden" class="photo" value="${photo}">
<script src="${pageContext.request.contextPath}/static/js/Pagination.js"></script>
</body>
</html>