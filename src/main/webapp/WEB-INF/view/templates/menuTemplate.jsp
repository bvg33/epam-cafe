<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 02.01.2021
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<head>
    <link href="${pageContext.request.contextPath}/static/styles/order.css" type="text/css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
</head>
<div class="workplace">
    <div class="page-info">
        <table id="table">
        </table>
        <ul id="pagination"></ul>
    </div>
</div>
<c:forEach var="menu" items="${sessionScope.menuList}">
    <input type="hidden" class="allIds" value="${menu.getId()}"/>
    <input type="hidden" class="allNames" value="${menu.getName()}"/>
    <input type="hidden" class="allPrice" value="${menu.getPrice()}"/>
    <input type="hidden" class="allPhotos" value="${menu.getPhoto()}"/>
</c:forEach>
<fmt:message bundle="${loc}" key="locale.tableColoumnPhoto" var="photo"/>
<fmt:message bundle="${loc}" key="locale.tableColoumnName" var="name"/>
<fmt:message bundle="${loc}" key="locale.tableColoumnPrice" var="price"/>
<input type="hidden" class="name" value="${name}">
<input type="hidden" class="price" value="${price}">
<input type="hidden" class="photo" value="${photo}">
