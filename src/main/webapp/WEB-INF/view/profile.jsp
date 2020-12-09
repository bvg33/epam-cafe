<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 01.12.2020
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
    <link href="${pageContext.request.contextPath}/static/styles/profile.css" type="text/css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<div class="workplace">
    <c:if test="${sessionScope.user!=null}">
        <div class="profile-info">
            <div class="info">
                <label> <fmt:message bundle="${loc}" key="locale.login"/></label>
                <input class="value" type="text" value="${sessionScope.user.login}">
            </div>
            <div class="info">
                <label><fmt:message bundle="${loc}" key="locale.name"/></label>
                <div>
                    <input class="value" type="text" value="${sessionScope.user.name}">
                </div>
            </div>
            <div class="info">
                <label><fmt:message bundle="${loc}" key="locale.cardNumber"/></label>
                <div>
                    <input class="value" type="text" value="${sessionScope.user.cardNumber}">
                </div>
            </div>
            <div class="info">
                <label><fmt:message bundle="${loc}" key="locale.loyality"/></label>
                <div>
                    <label class="value"><fmt:message bundle="${loc}" key="locale.loyalityMessage"/> ${sessionScope.user.loyality}</label>
                </div>
            </div>
            <fmt:message bundle="${loc}" key="locale.saveChangesButton" var="saveChngBtn"/>
            <input class="make-changes" type="submit" value="${saveChngBtn}"/>
        </div>
    </c:if>
</div>
<jsp:include page="templates/sidebar.jsp"/>
</body>
</html>
