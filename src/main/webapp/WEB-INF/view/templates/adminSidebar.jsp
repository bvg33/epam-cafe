<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 29.12.2020
  Time: 23:25
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
        <button class="adminSideButton" type="submit" name="command" value="goToAdminPage">
            <fmt:message bundle="${loc}" key="locale.users"/>
        </button>
    </form>
    <form>
        <button class="adminSideButton" type="submit" name="command" value="goToAllOrdersPage">
            <fmt:message bundle="${loc}" key="locale.orders"/>
        </button>
    </form>
    <form>
        <button class="adminSideButton" type="submit" name="command" value="goToNewDishPage">
            <fmt:message bundle="${loc}" key="locale.newDish"/>
        </button>
    </form>
    <form>
        <button class="adminSideButton" type="submit" name="command" value="goToRemoveFromMenuPage">
            <fmt:message bundle="${loc}" key="locale.menu"/>
        </button>
    </form>
    <form>
        <button class="adminSideButton" type="submit" name="command" value="goToPickedOrders">
            <fmt:message bundle="${loc}" key="locale.ordersHistory"/>
        </button>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/js/AdminSidebarButtonsColor.js"></script>
</html>
