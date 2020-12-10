<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 14.11.2020
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/static/styles/login.css" type="text/css" rel="stylesheet">
    <title>EPAM-cafe login</title>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<div class="main">
    <div class="registration-form">
        <div class="text">
            <fmt:message bundle="${loc}" key="locale.fillMessage"/>
        </div>
        <form name="login" action=${pageContext.request.contextPath}/controller method="post">
            <hr>

            <input type="hidden" name="command" value="login"/>

            <div class="login">
                <label><b><fmt:message bundle="${loc}" key="locale.login"/></b></label>
                <fmt:message bundle="${loc}" key="locale.loginPlaceholder" var="logPlch"/>
                <input type="text" class="input-field" placeholder="${logPlch}" name="login">
            </div>

            <div class="password">
                <label><b><fmt:message bundle="${loc}" key="locale.password"/></b></label>
                <fmt:message bundle="${loc}" key="locale.passwordPlaceholder" var="pswPlch"/>
                <div>
                    <input type="password" class="input-field" placeholder="${pswPlch}" name="password"/>
                    <button class="eye-button" type="button"><img
                            src="${pageContext.request.contextPath}/static/images/eye.png"
                            width="35" height="27"></button>
                </div>
            </div>
            <fmt:message bundle="${loc}" key="locale.loginButtonValue" var="logBtn"/>
            <input class="button-login" type="submit" name="button" value="${logBtn}">
            </hr>
        </form>
        <c:if test="${errorMessage=='true'}">
            <div class="error">
                <fmt:message bundle="${loc}" key="locale.loginError"/>
            </div>
        </c:if>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/HidePassword.js"></script>
</body>
</html>