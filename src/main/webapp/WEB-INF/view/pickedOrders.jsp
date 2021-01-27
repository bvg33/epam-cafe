<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 12.01.2021
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ctg" uri="/WEB-INF/custom.tld" %>
<html>
<head>
    <title>Orders history</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <link href="${pageContext.request.contextPath}/static/styles/pickedOrders.css" type="text/css" rel="stylesheet">
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
                        <th><fmt:message bundle="${loc}" key="locale.evaluation"/></th>
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
                                <fmt:message bundle="${loc}" key="locale.${dish.getState().getKey()}" var="currentDishState"/>
                                <label class="label">${currentDishState}</label>
                            </td>
                            <c:if test="${dish.getRating()!=0}">
                                <td class="order-rating-td"></td>
                                <input type="hidden" class="order-rating" name="rating" value="${dish.getRating()}">
                            </c:if>
                            <c:if test="${dish.getRating()==0}">
                                <td><fmt:message bundle="${loc}" key="locale.notEvaluated"/></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </div>
</div>
<jsp:include page="templates/adminSidebar.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/StarsDrowing.js"></script>
</body>
</html>