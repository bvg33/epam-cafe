<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 25.11.2020
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/static/styles/sidebar.css" type="text/css" rel="stylesheet">
</head>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<div class="sidebar">
    <form>
        <button type="submit"  class="sideButton" id="default" name="command" value="goToOrderPage">
            <fmt:message bundle="${loc}" key="locale.order"/>
        </button>
    </form>
    <form>
        <button type="submit" class="sideButton" name="command" value="goToProfilePage">
            <fmt:message bundle="${loc}" key="locale.myProfile"/>
        </button>
    </form>
    <form>
        <button type="submit" class="sideButton" name="command" value="goToEvaluatePage">
            <fmt:message bundle="${loc}" key="locale.evaluateOrder"/>
        </button>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/js/SidebarButtonsColor.js"></script>
</html>