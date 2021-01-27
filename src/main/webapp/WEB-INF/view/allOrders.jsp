<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 08.01.2021
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="/WEB-INF/custom.tld" %>
<html>
<head>
    <title>All Orders</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <link href="${pageContext.request.contextPath}/static/styles/allOrders.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<div class="workplace">
    <div class="page-info">
        <c:if test="${orders!=null && orders.isEmpty()!=true}">
            <div class="page-info">
                <table id="table">
                    <tr>
                        <th><fmt:message bundle="${loc}" key="locale.login"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.dishes"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.tableColoumnPrice"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.cash"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.issueTime"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.state"/></th>
                        <th><fmt:message bundle="${loc}" key="locale.applyChanges"/></th>
                    </tr>
                    <c:forEach var="dish" items="${orders}">
                        <tr>
                            <td>${dish.getLogin()}</td>
                            <td>${dish.getDishes()}</td>
                            <td>${dish.getPrice()} BYN</td>
                            <td>
                                <c:choose>
                                    <c:when test="${dish.getCash()=='CASH'}">
                                        <fmt:message bundle="${loc}" key="locale.cash"/>
                                    </c:when>
                                    <c:when test="${dish.getCash()=='NO_CASH'}">
                                        <fmt:message bundle="${loc}" key="locale.noCash"/>
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>
                                <ctg:date date="${dish.getTime()}"/>
                            </td>
                            <td>
                                <button class="prev-state-button">
                                    ◀
                                </button>
                                <fmt:message bundle="${loc}" key="locale.${dish.getState().getKey()}" var="currentDishState"/>
                                <label class="label">${currentDishState}</label>
                                <input type="hidden" class="current-state"
                                       value="${dish.getState().getEng().toString()}">
                                <button class="next-state-button">
                                    ▶
                                </button>
                            </td>
                            <td>
                                <form class="form" method="post"
                                      action="${pageContext.request.contextPath}/controller?command=updateOrderStatus">
                                    <button class="apply-button" type="submit">
                                        <fmt:message bundle="${loc}" key="locale.applyChanges"/>
                                    </button>
                                    <input type="hidden" name="id" value="${dish.getId()}">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </div>
</div>
<c:forEach var="state" items="${states}">
    <input type="hidden" class="all-eng-states" value="${state.getEng().toString()}">
    <fmt:message bundle="${loc}" key="locale.${state.getKey()}" var="currentState"/>
    <input type="hidden" class="all-states" value="${currentState}">
</c:forEach>
<jsp:include page="templates/adminSidebar.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/ChangeState.js"></script>
</body>
</html>
